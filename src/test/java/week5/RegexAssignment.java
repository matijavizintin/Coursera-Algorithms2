package week5;

import org.junit.Test;
import week5.regex.NFA;

/**
 * Created by matijav on 11/02/2017.
 */
public class RegexAssignment {

    @Test
    public void test1() {
        NFA nfa = new NFA("(A((C*B)|A)*)");
        nfa.DEBUG = true;
        nfa.recognizes("AABBBC");
    }

    @Test
    public void test2() {
        NFA nfa = new NFA("(A(D|(BC*)*))");
        nfa.debugPrintGraph();
    }
}
