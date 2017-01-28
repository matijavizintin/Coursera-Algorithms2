package week3.radix;

import week3.radix.substring.Substring;

import java.util.Arrays;

/**
 * Created by Matija Vižintin
 * Date: 20. 12. 2015
 * Time: 14:08
 */
public class LongestRepeatedSubstring {

    /**
     * This algorithm was fixed with a custom Substring class to be memory effective. Substring doesn't create new
     * strings as String.substring does but instead allocated only 2 new integers (pointers) to the beginning and
     * and of the new substring as the previous java implementation did. The original string is only passed as a
     * reference consuming barely 8 bytes of memory. All operations are constant time as they should be, except
     * obviously asString() that creates a new string.
     *
     * ORIGINAL COMMENT:
     * This algorithm consumes GIGANTIC amounts of memory. Example: a string with 120k characters consumed more than
     * 10GB of memory!!! This is due to a change in jdk7v06 of String.substring method. From that version on it makes
     * a copy of the underlying array of characters and doesn't reuse the original array.
     *
     * @param s     String
     * @return      longest prefix
     */
    public String find(String s) {
        int N = s.length();

        // create all possible suffixes
        Substring[] suffixes = new Substring[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = new Substring(s, i, N);
        }

        // sort
        Arrays.sort(suffixes);

        // find longest common prefix between adjacent suffixes
        Substring lrs = new Substring("", 0, 0);
        for (int i = 0; i < N - 1; i++) {
            int len = lcp(suffixes[i], suffixes[i + 1]);
            if (len > lrs.length()) {
                lrs = suffixes[i].substring(0, len);
            }
        }
        return lrs.asString();
    }

    private int lcp(Substring s1, Substring s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return i;
            }
        }
        return Math.min(s1.length(), s2.length());
    }
}