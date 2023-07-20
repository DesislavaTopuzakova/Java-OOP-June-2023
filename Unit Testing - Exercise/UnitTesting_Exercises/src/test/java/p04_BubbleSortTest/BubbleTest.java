package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    @Test
    public void testBubbleSort() {
        int [] numbers = {34, 0, 2, 45, 67, 87, 1, 3, 99, 12};
        Bubble.sort(numbers); //нарастващ ред
        int [] expected = {0, 1, 2, 3, 12, 34, 45, 67, 87, 99};
        Assert.assertArrayEquals(numbers, expected);
    }
}
