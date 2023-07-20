package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"Desi", "Miroslav", "Boris", "Petar"};

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }
    //1. конструктор
    //1.1. празен списък с елементи
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    //2. hasNext + move
    @Test
    public void testMove () {
        // {"Desi", "Miroslav", "Boris", "Petar"} -> current = 0
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //{"Desi", "Miroslav", "Boris", "Petar"} -> current = 1
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //{"Desi", "Miroslav", "Boris", "Petar"} -> current = 2
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        //{"Desi", "Miroslav", "Boris", "Petar"} -> current = 3
        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());
    }

    //3. print
    //3.1. празен списък с елементи
    @Test (expected = IllegalStateException.class)
    public void testPrintEmptyList () throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }
    //3.2. списък с елементи
    @Test
    public void testPrintCorrectly() {
        //{"Desi", "Miroslav", "Boris", "Petar"} -> current = 0
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), DATA[index]);
            index++;
            listIterator.move(); //current += 1
        }
    }
}
