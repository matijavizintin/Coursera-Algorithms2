package week5.datacompression;

import edu.princeton.cs.algs4.TST;

import java.io.ByteArrayOutputStream;

/**
 * Created by matijav on 15/02/2017.
 */
public class LZW {
    private final int R = 127;      // num of input chars - ASCII
    private final int L = 256;     // num of codewords - 2^W
    private final int W = 8;       // codeword width

    public byte[] compress(String input) {
        TST<Integer> st = new TST<>();

        // put all chars to st
        for (int i = 0; i < R; i++) {
            st.put(Character.toString((char) i), i);
        }
        int code = R + 1;

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        while (input.length() > 0) {
            String prefix = st.longestPrefixOf(input);
            os.write(st.get(prefix));       // encode prefix

            int t = prefix.length();
            if (t < input.length() && code < L) {
                st.put(input.substring(0, t + 1), code++);      // write longest prefix + next letter to st
            }
            input = input.substring(t);
        }

        os.write(R);    // EOF
        return os.toByteArray();
    }

    public String expand(byte[] input) {
        String[] st = new String[L];

        // init with all chars
        int i;
        for (i = 0; i < R; i++) {
            st[i] = Character.toString((char) i);
        }
        st[i++] = "";

        // remember first code for special case
        int pos = 0;
        int codeword = input[pos++];
        if (codeword == R) return "";
        String val = st[codeword];

        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(val);

            codeword = input[pos++];
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
