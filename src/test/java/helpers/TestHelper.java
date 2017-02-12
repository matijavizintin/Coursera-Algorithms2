package helpers;

import org.junit.Assert;

import java.util.Iterator;

/**
 * Created by matijav on 03/02/2017.
 */
public class TestHelper extends Assert {

    public static <T> void assertIterableEquals(Iterable<T> a, Iterable<T> b) {
        Iterator<T> i1 = a.iterator();
        Iterator<T> i2 = b.iterator();

        while (true) {
            boolean has1 = i1.hasNext();
            boolean has2 = i2.hasNext();

            if (has1 != has2) {
                fail("Not equals number of elements");
            }
            if (!has1) {
                break;
            }

            T e1 = i1.next();
            T e2 = i2.next();
            assertEquals(e1, e2);
        }
    }
}
