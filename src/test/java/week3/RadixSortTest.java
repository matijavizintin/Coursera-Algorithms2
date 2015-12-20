package week3;

import com.google.common.base.Joiner;
import org.junit.Test;
import week3.radix.*;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by Matija Vižintin
 * Date: 14. 12. 2015
 * Time: 21:53
 */
public class RadixSortTest {
    private final int N = 1000000;
    private final int W_min = 10;
    private final int W_max = 15;

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
        final int W = 13;
        String[] input = StringArraysGenerator.generate(N, W);

        // sort
        new LSDRadixSort().sort(input, W);
        assertAndPrint(input, false);
    }

    @Test
    public void msdSortTest() {
        String[] input = StringArraysGenerator.generate(N, W_min, W_max);

        // sort
        new MSDRadixSort().sort(input);
        assertAndPrint(input, false);
    }

    @Test
    public void qSortTest() {
        String[] input = StringArraysGenerator.generate(N, W_min, W_max);

        Arrays.sort(input);
        assertAndPrint(input, false);
    }

    @Test
    public void threeWayQSortTest() {
        String[] input = StringArraysGenerator.generate(N, W_min, W_max);

        // sort
        new ThreeWayQuickSort().sort(input);
        assertAndPrint(input, false);
    }

    @Test
    public void longestRepeatedSubstringTest() {
        String[] input = StringArraysGenerator.generate(1000, W_min, W_max);
        String joined = Joiner.on("").join(input);      // estimated 12.5 * 1k characters
        System.out.println("Input length: " + joined.length());

        // find longest
        String longest = new LongestRepeatedSubstring().find(joined);
        System.out.printf("longest.len = %d, value = %s\n", longest.length(), longest);
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
