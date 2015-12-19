package week3;

import org.junit.Test;
import week3.radix.KeyIndexedCounting;
import week3.radix.LSDRadixSort;
import week3.radix.MSDRadixSort;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by Matija Vižintin
 * Date: 14. 12. 2015
 * Time: 21:53
 */
public class RadixSortTest {

    @Test
    public void keyIndexedCountingTest() {
        int[] a = new int[]{3, 0, 2, 5, 5, 1, 3, 1, 5, 1, 4, 0};
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

    @Test
    public void lsdSortTest() {
        final int N = 1000000;
        final int W = 13;
        String[] input = StringArraysGenerator.generate(N, W);

        // sort
        new LSDRadixSort().sort(input, W);
        assertAndPrint(input, false);
    }

    @Test
    public void msdSortTest() {
        final int N = 1000000;
        final int W_min = 10;
        final int W_max = 15;
        String[] input = StringArraysGenerator.generate(N, W_min, W_max);

        // sort
        new MSDRadixSort().sort(input);
        assertAndPrint(input, false);
    }

    @Test
    public void qSortTest() {
        final int N = 1000000;
        final int W_min = 10;
        final int W_max = 15;
        String[] input = StringArraysGenerator.generate(N, W_min, W_max);

        Arrays.sort(input);
        assertAndPrint(input, false);
    }

    private <T extends Comparable<T>> void assertAndPrint(T[] input, boolean print) {
        // assert
        for (int i = 0; i < input.length - 1; i++) {
            assertTrue(input[i].compareTo(input[i + 1]) <= 0);
        }

        // print
        if (print)
            for (T i : input) {
                System.out.printf("%s\n", i);
            }
    }
}
