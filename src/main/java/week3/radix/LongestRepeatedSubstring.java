package week3.radix;

import java.util.Arrays;

/**
 * Created by Matija Vižintin
 * Date: 20. 12. 2015
 * Time: 14:08
 */
public class LongestRepeatedSubstring {

    /**
     * This algorithm consumes GIGANTIC amounts of memory. Example: a string with 120k characters consumed more than
     * 10GB of memory!!! This is due to a change in jdk7v06 of String.substring method. From that version on it makes
     * a copy of the underlying array of characters and doesn't reuse the original array.
     *
     * TODO: change the algorithm to use the original string and store only the pointers to substring - like the old
     * jdk did. This will require a custom sorting algorithm.
     *
     * @param s     String
     * @return      longest prefix
     */
    public String find(String s) {
        int N = s.length();

        // create all possible suffixes
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = new String(s.substring(i, N));
        }

        // sort
        Arrays.sort(suffixes);

        // find longest common prefix between adjacent suffixes
        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            int len = lcp(suffixes[i], suffixes[i + 1]);
            if (len > lrs.length()) {
                lrs = suffixes[i].substring(0, len);
            }
        }
        return lrs;
    }

    public int lcp(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }
        return Math.min(s1.length(), s2.length());
    }
}
