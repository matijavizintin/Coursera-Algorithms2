package week3.radix;

/**
 * Created by Matija Vižintin
 * Date: 19. 12. 2015
 * Time: 22:16
 *
 * MSD = most significant digit
 */
public class MSDRadixSort {
    private static final int INSERTION_SORT_CUT_OFF = 7;
    private static final int R = 256;
    public static boolean DEBUG = false;
    public static int DEBUG_PRINT_COUNT = 3;
    public static int sortCount = 0;

    public void sort(String[] a) {
        final int N = a.length;
        String[] aux = new String[N];

        // recursive sort
        sort(a, aux, 0, N - 1, 0);
    }

    private void sort(String[] a, String[] aux, int lo, int hi, int d) {
        if (hi <= lo) return;

        // check for cutoff
        if (!DEBUG && hi - lo < INSERTION_SORT_CUT_OFF) {
            insertionSort(a, lo, hi, d);
            return;
        }

        // execute key index counting
        int[] count = new int[R + 2];

        // count frequency and compute cumulates
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        // move to aux array in sorted order and copy back to original array
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        if (DEBUG && ++sortCount == DEBUG_PRINT_COUNT) {
            System.out.println("sortCount = " + sortCount);
            for (String element : a) {
                System.out.print(element + " ");
            }
            System.out.println("\n");
        }

        // recursive sub-array sort
        for (int r = 0; r < R; r++) {
            sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    private void insertionSort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exchange(a, j, j - 1);
            }
        }
    }

    private char charAt(String s, int d) {
        return s.length() > d ? s.charAt(d) : (char)-1;
    }

    private boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private void exchange(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
