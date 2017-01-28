package week3.radix;

/**
 * Created by Matija Vižintin
 * Date: 20. 12. 2015
 * Time: 13:34
 */
public class ThreeWayQuickSort {
    public static final boolean DEBUG = true;

    public void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) return;

        // init vars
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);       // pivot
        int i = lo + 1;

        // loop until we reach the limit
        while (i <= gt) {
            int t = charAt(a[i], d);

            if (t < v) exchange(a, lt++, i++);      // lower than pivot - raise the lower limit
            else if (t > v) exchange(a, i, gt--);   // greater than pivot - decrease the upper limit
            else i++;

            if (DEBUG && i > gt) {
                System.out.printf("lo = %d, hi = %d, lt = %d, i = %d, gt = %d\n", lo, hi, lt, i, gt);
                for (String element : a) {
                    System.out.print(element + " ");
                }
                System.out.println("\n");
            }
        }

        // recursive sort of 3 sub-arrays
        sort(a, lo, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }

    private char charAt(String s, int d) {
        return s.length() > d ? s.charAt(d) : (char)-1;
    }

    private void exchange(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
