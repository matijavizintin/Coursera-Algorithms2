package week5.datacompression;

import edu.princeton.cs.algs4.TST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matijav on 15/02/2017.
 */
public class LZW {
    private final int R;      // num of input chars - ASCII
    private final int L;     // num of codewords - 2^W

    public LZW(int R, int W) {
        this.R = R;
        this.L = 1 << W;
    }

    public List<Integer> compress(String input) {
        TST<Integer> st = new TST<>();

        // put all chars to st
        for (int i = 0; i < R; i++) {
            st.put(Character.toString((char) i), i);
        }
        int code = R + 1;

        List<Integer> result = new ArrayList<>();
        while (input.length() > 0) {
            String prefix = st.longestPrefixOf(input);
            result.add(st.get(prefix));       // encode prefix

            int t = prefix.length();
            if (t < input.length() && code < L) {
                st.put(input.substring(0, t + 1), code++);      // write longest prefix + next letter to st
            }
            input = input.substring(t);
        }

        result.add(R);    // EOF
        return result;
    }

    public String expand(List<Integer> input) {
        String[] st = new String[L];

        // init with all chars
        int i;
        for (i = 0; i < R; i++) {
            st[i] = Character.toString((char) i);
        }
        st[i++] = "";

        // remember first code for special case
        int pos = 0;
        int codeword = input.get(pos++);
        if (codeword == R) return "";
        String val = st[codeword];

        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(val);

            codeword = input.get(pos++);
            if (codeword == R) {
                break;
            }

            String s = st[codeword];
            if (i == codeword) {
                s = val + val.charAt(0);        // special case
            }
            if (i < L) {
                st[i++] = val + s.charAt(0);
            }
            val = s;
        }

        return sb.toString();
    }
}
