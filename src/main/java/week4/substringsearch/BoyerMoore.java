package week4.substringsearch;

/**
 * Created by matijav on 05/02/2017.
 */
public class BoyerMoore {
    private static final int R = 256;
    public boolean debug = true;
    private int M;
    private String pattern;
    private int[] right;

    public BoyerMoore(String pattern) {
        this.pattern = pattern;
        this.M = pattern.length();

        precompute(pattern);
    }

    public int search(String text) {
        int N = text.length();
        int skip;

        // go through the text
        for (int i = 0; i < N - M + 1; i += skip) {
            skip = 0;

            // check if we found a match backwards
            for (int j = M - 1; j >= 0; j--) {
                if (debug && j == M - 1) {
                    System.out.print(text.charAt(i + j) + " ");
                }

                // if character doesn't match then skip to the most right match
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }
            }

            if (skip == 0) return i;
        }
        return N;
    }

    private void precompute(String pattern) {
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }

        // rightmost occurrence of character c
        for (int j = 0; j < M; j++) {
            right[pattern.charAt(j)] = j;
        }

    }
}
