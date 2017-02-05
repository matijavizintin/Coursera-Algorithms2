package week4.substringsearch;

/**
 * Created by matijav on 03/02/2017.
 */
public class BruteForce {

    public static int search(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();

        OUT:
        for (int i = 0; i <= N - M; i++) {
            for (int j = 0; j < M; j++) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    continue OUT;
                }
            }
            return i;
        }
        return N;
    }

    public static int search2(String pattern, String text) {
        int i, N = text.length();
        int j, M = pattern.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }

        if (j == M) return i - M;
        else return N;
    }
}
