package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "Desi"),
                                            new Person(2, "Plamen"),
                                            new Person(3, "Vasil")};
    @Before //изпълнява преди всеки тест
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    //1. конструктор
    //1.1. дали създава правилен обект
    @Test
    public void testConstructorHasCreateCorrectObject() throws OperationNotSupportedException {
        //database
        //elements: [{1, Desi}, {2, Plamen}, {3, Vasil}]
        Person[] databaseElements = database.getElements();
        Assert.assertArrayEquals("Arrays are not the same!", PEOPLE, databaseElements);
        //elementsCount = 3
        Assert.assertEquals("Count of element is incorrect!", database.getElementsCount(), PEOPLE.length);
        //index = 2
        Assert.assertEquals("Index is incorrect!", PEOPLE.length - 1, database.getIndex());
    }

    //1.2. създаваме обект с повече от 16 човека
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionMoreThanSixteenElements () throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    //1.3. създаваме обект с по-малко от 1 елемент
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenLessOneElement () throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    //2. add
    //2.1. добавяме null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    //2.2. успешно добавяне на елемент
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        Person[] elementsBefore = database.getElements();
        //elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        database.add(new Person(4, "Hristo"));
        Person[] elementsAfter = database.getElements();
        //elements: [{1, Desi}, {2, Plamen}, {3, Vasil}, {4, Hristo}] -> 4 броя

        //1. броя на елементите се е увеличил с 1
        Assert.assertEquals("Invalid add operation!", elementsBefore.length + 1, elementsAfter.length);
        //2. добавен правилния елемент
        //последния ми елемент да е {4, Hristo}
        Person lastPerson = elementsAfter[elementsAfter.length - 1];
        Assert.assertEquals(lastPerson.getId(), 4);
        Assert.assertEquals(lastPerson.getUsername(), "Hristo");
    }

    //3. remove
    //3.1. успешно премахваме елемент
    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        //database
        //elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        Person[] elementsBefore = database.getElements();
        //премахване на последния елемент
        database.remove();
        //elements: [{1, Desi}, {2, Plamen}] -> 2 броя
        Person[] elementsAfter = database.getElements();
        //1. броя на елементите
        Assert.assertEquals("Invalid remove operation!", elementsBefore.length - 1, elementsAfter.length);
        //2. дали е премахнат последния елемент -> нов последен елемент
        Person currentLast = elementsAfter[elementsAfter.length - 1];
        Assert.assertEquals(currentLast.getUsername(), "Plamen");
        Assert.assertEquals(currentLast.getId(), 2);
    }

    //3.2. неуспешно премахване заради ArrayIndexOutOfBoundException
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionInvalidIndex() throws OperationNotSupportedException {
        //elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        //премахваме всички елементи
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        //празен database: {} => 0 елемента; index = -1
        database.remove();
    }


    //4. findByUsername
    //4.1. username e null
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExceptionNullParam() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    //4.2. подаваме валиден username -> връщаме Person с този username
    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        //database => elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        Person person = database.findByUsername("Plamen");
        //person{username: "Plamen", id: 2}
        Assert.assertEquals("Invalid id of the taken person!", person.getId(), 2);
        Assert.assertEquals("Invalid username of the taken person!", person.getUsername(), "Plamen");
    }

    //4.3. имаме повече от 1 човек с даденото име
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMoreThanPerson() throws OperationNotSupportedException {
        //database => elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        database.add(new Person(4, "Vasil"));
        //database => elements: [{1, Desi}, {2, Plamen}, {3, Vasil}, {4, Vasil}] -> 4 броя
        database.findByUsername("Vasil");
    }

    //4.4. нямаме човек с това име
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameNonExistingUsername () throws OperationNotSupportedException {
        //database => elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        database.findByUsername("Pesho");
    }

    //5. findById
    //5.1. подаваме валидно id -> получаваме човек с даденото id
    @Test
    public void testFindById() throws OperationNotSupportedException {
        //database => elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        Person person = database.findById(3);
        //person: {id: 3, username: Vasil}
        Assert.assertEquals("Invalid id of the taken person!", person.getId(), 3);
        Assert.assertEquals("Invalid username of the taken person!", person.getUsername(), "Vasil");
    }

    //5.2. имаме повече от 1 човек с това id
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMoreThanOneId() throws OperationNotSupportedException {
        //database => elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        database.add(new Person(3, "Ivan"));
        //database => elements: [{1, Desi}, {2, Plamen}, {3, Vasil}, {3, Ivan}] -> 4 броя
        database.findById(3);
    }

    //5.3. нямаме човек с такова id
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowExceptionNonExistingId() throws OperationNotSupportedException {
        //database => elements: [{1, Desi}, {2, Plamen}, {3, Vasil}] -> 3 броя
        database.findById(4);
    }

}
