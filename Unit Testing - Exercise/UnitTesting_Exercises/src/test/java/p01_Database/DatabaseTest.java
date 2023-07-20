package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {3, 4, 5, 8, 9, 10};
    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    //1. конструктор
    //1.1. дали създава правилен обект
    @Test
    public void testConstructorHasCreateCorrectObject() throws OperationNotSupportedException {
        //database
        //elements: {3, 4, 5, 8, 9, 10}
        Integer[] databaseElements = database.getElements();
        Assert.assertArrayEquals("Arrays are not the same!",NUMBERS, databaseElements);
        //elementsCount = 6
        Assert.assertEquals("Count of element is incorrect!", database.getElementsCount(), NUMBERS.length);
        //index = 5
        Assert.assertEquals("Index is incorrect!", NUMBERS.length - 1, database.getIndex());
    }

    //1.2. създаваме обект с повече от 16 елемента
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionMoreThanSixteenElements () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    //1.3. създаваме обект с по-малко от 1 елемент
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenLessOneElement () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
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
        Integer[] elementsBefore = database.getElements();
        //elements: {3, 4, 5, 8, 9, 10} -> 6 броя
        database.add(64);
        Integer[] elementsAfter = database.getElements();
        //elements: {3, 4, 5, 8, 9, 10, 64} -> 7 броя

        //1. броя на елементите се е увеличил с 1
        Assert.assertEquals("Invalid add operation!", elementsBefore.length + 1, elementsAfter.length);
        //2. добавен правилния елемент
        Assert.assertEquals(elementsAfter[elementsAfter.length - 1], Integer.valueOf(64));
    }

    //3. remove
    //3.1. успешно премахваме елемент
    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        //database
        //elements: {3, 4, 5, 8, 9, 10} -> 6 броя
        Integer[] elementsBefore = database.getElements();
        //премахване на последния елемент
        database.remove();
        //elements: {3, 4, 5, 8, 9} -> 5 броя
        Integer[] elementAfter = database.getElements();
        //1. броя на елементите
        Assert.assertEquals("Invalid remove operation!", elementsBefore.length - 1, elementAfter.length);
        //2. дали е премахнат последния елемент -> нов последен елемент
        Assert.assertEquals(elementAfter[elementAfter.length - 1], Integer.valueOf(9));
    }

    //3.2. неуспешно премахване заради ArrayIndexOutOfBoundException
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionInvalidIndex() throws OperationNotSupportedException {
        //database: {3, 4, 5, 8, 9, 10}

        //премахваме всички елементи
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        //празен database: {} => 0 елемента; index = -1
        database.remove();
    }


}
