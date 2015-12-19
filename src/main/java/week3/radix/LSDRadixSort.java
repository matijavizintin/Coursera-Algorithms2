package week3.radix;

/**
 * Created by Matija Vižintin
 * Date: 19. 12. 2015
 * Time: 21:15
 *
 * LSD = least significant digit not to be confused :)
 */
public class LSDRadixSort {

    public void sort(String[] array, int W) {
        int R = 256;
        int N = array.length;
        String[] aux = new String[N];

        // key index counting for each digit from right to left
        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            // count frequency and compute cumulates
            for (int i = 0; i < N; i++) {
                count[array[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // move to aux array in sorted order an copy back to original array
            for (int i = 0; i < N; i++) {
                aux[count[array[i].charAt(d)]++] = array[i];
            }
            for (int i = 0; i < N; i++) {
                array[i] = aux[i];
            }
        }
    }
}
