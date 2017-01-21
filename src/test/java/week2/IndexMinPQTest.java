package week2;

import org.junit.Assert;
import org.junit.Test;
import week2.structures.pq.IndexMinPQ;

/**
 * Created by matijav on 21/01/2017.
 */
public class IndexMinPQTest {

    @Test()
    public void testInsertionAndRetrieval() {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(10);
        for (int i = 0; i < 10; i++) {
            minPQ.insert(i, 10 - i);
        }

        Assert.assertFalse(minPQ.isEmpty());
        Assert.assertEquals(10, minPQ.size());

        for (int i = 1; i <= 10; i++) {
            Assert.assertEquals(new Integer(i), minPQ.minKey());
            Assert.assertEquals(10 - i, minPQ.delMin());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertionOutOfBounds() {
        new IndexMinPQ<Integer>(1).insert(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertionDoubleInsertion() {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(1);
        minPQ.insert(0, 1);
        minPQ.insert(0, 1);
    }

    @Test
    public void testDecreaseKey() {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(5);
        minPQ.insert(0, 5);
        minPQ.insert(1, 10);
        Assert.assertEquals(new Integer(5), minPQ.minKey());

        minPQ.decreaseKey(1, 2);
        Assert.assertEquals(new Integer(2), minPQ.minKey());
        Assert.assertEquals(1, minPQ.delMin());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDecreaseOutOfBounds() {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(5);
        minPQ.insert(0, 5);
        minPQ.decreaseKey(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseInvalid() {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(5);
        minPQ.insert(0, 5);
        minPQ.decreaseKey(0, 10);
    }
}
