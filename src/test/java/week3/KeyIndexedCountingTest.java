package week3;

import org.junit.Test;
import week3.radix.KeyIndexedCounting;

import static org.junit.Assert.assertTrue;

/**
 * Created by Matija Vižintin
 * Date: 14. 12. 2015
 * Time: 21:53
 */
public class KeyIndexedCountingTest {

    @Test
    public void test() {
        int[] a = new int[] {3, 0, 2, 5, 5, 1, 3, 1, 5, 1, 4, 0};
        int R = 6;

        // in-place sort
        new KeyIndexedCounting().sort(a, R);

        // assert
        for (int i = 0; i < a.length - 1; i++) {
            assertTrue(a[i] <= a[i + 1]);
        }

        // print
        for (int i : a) {
            System.out.printf("%d ", i);
        }
    }
}
