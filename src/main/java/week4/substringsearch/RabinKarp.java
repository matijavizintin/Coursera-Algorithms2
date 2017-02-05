package week4.substringsearch;

/**
 * Created by matijav on 05/02/2017.
 */
public class RabinKarp {
    public static int R = 256;
    public static long Q = 179426549;

    private long patternHash;       // pattern hash value
    private int M;
    private long RM;            // R^(M-1) % Q

    public RabinKarp(String pattern) {
        M = pattern.length();

        RM = 1;
        for (int i = 1; i < M; i++) {
            RM = (R * RM) % Q;
        }
        patternHash = hash(pattern, M);
    }

    public int search(String text) {
        int N = text.length();
        long textHash = hash(text, M);

        // if initial pattern hash match
        if (patternHash == textHash) return 0;

        for (int i = M; i < N; i++) {
            textHash = (textHash + Q - RM * text.charAt(i - M) % Q) % Q;    // remove first char from hash
            textHash = (textHash * R + text.charAt(i)) % Q;                 // add new char to hash

            if (patternHash == textHash) {
                return i - M + 1;
            }
        }
        return N;
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }
}
