package week3.radix;

/**
 * Created by Matija Vižintin
 * Date: 14. 12. 2015
 * Time: 21:48
 *
 * NOTE: this is a linear time (~ 11N + 4R) stable soring method
 */
public class KeyIndexedCounting {

    // in-place key-indexed sort
    public void sort(int[] a, int R) {
        int N = a.length;

        // create an array to count keys
        int[] count = new int[R + 1];

        // create temporary auxiliary array
        int[] aux = new int[N];

        // count frequencies
        for (int i = 0; i < N; i++) {
            count[a[i] + 1]++;
        }

        // compute cumulates
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        // move to auxiliary array according to frequency
        for (int i = 0; i < N; i++) {
            aux[count[a[i]]++] = a[i];
        }

        // copy sorted back
        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
        }
    }
}
