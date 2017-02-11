package week5.regex;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matijav on 11/02/2017.
 */
public class GREP {

    public static void main(String[] args) {
        String regex = "(.*" + args[0] + ".*)";
        NFA nfa = new NFA(regex);

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            if (nfa.recognizes(line)) {
                StdOut.println(line);
            }
        }
    }
}
