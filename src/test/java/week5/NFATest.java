package week5;

import org.junit.Assert;
import org.junit.Test;
import week5.regex.NFA;

/**
 * Created by matijav on 11/02/2017.
 */
public class NFATest {

    @Test
    public void testNFA1() {
        NFA nfa = new NFA("A(A)*B");

        boolean result = nfa.recognizes("AB");
        Assert.assertTrue(result);

        result = nfa.recognizes("AAAAAAB");
        Assert.assertTrue(result);

        result = nfa.recognizes("AAB");
        Assert.assertTrue(result);

        result = nfa.recognizes("ABA");
        Assert.assertFalse(result);

        result = nfa.recognizes("B");
        Assert.assertFalse(result);

        result = nfa.recognizes("BAA");
        Assert.assertFalse(result);
    }

    @Test
    public void testNFA2() {
        NFA nfa = new NFA("ABC(AB|D)*B");

        boolean result = nfa.recognizes("ABCABB");
        Assert.assertTrue(result);

        result = nfa.recognizes("ABCDB");
        Assert.assertTrue(result);

        result = nfa.recognizes("ABCABDDDDABB");
        Assert.assertTrue(result);

        result = nfa.recognizes("ABCABDDDABABABABDABDDABABDB");
        Assert.assertTrue(result);

        result = nfa.recognizes("ABCAB");
        Assert.assertFalse(result);

        result = nfa.recognizes("ABCD");
        Assert.assertFalse(result);

        result = nfa.recognizes("ABCB");
        Assert.assertTrue(result);


        result = nfa.recognizes("B");
        Assert.assertFalse(result);

        result = nfa.recognizes("ABB");
        Assert.assertFalse(result);

        result = nfa.recognizes("DB");
        Assert.assertFalse(result);
    }

    @Test
    public void testNFA3() {
        NFA nfa = new NFA("((AB)*(AC|BC)*AA(D)*)*");

        boolean result = nfa.recognizes("ABACAADABBCAAD");
        Assert.assertTrue(result);

        result = nfa.recognizes("AA");
        Assert.assertTrue(result);

        result = nfa.recognizes("ABABABABACBCBCBCAADDDDDDABAA");
        Assert.assertTrue(result);

        result = nfa.recognizes("AAAAAAAAAAAAAA");
        Assert.assertTrue(result);

        result = nfa.recognizes("BCAA");
        Assert.assertTrue(result);

        result = nfa.recognizes("ABAA");
        Assert.assertTrue(result);

        result = nfa.recognizes("AAD");
        Assert.assertTrue(result);

        result = nfa.recognizes("ABACAD");
        Assert.assertFalse(result);

        result = nfa.recognizes("BCADABBCAAD");
        Assert.assertFalse(result);

        result = nfa.recognizes("ABABABABCBCBCA");
        Assert.assertFalse(result);

        result = nfa.recognizes("ABACAADDDDDDDABABABAACACACBCBCBCAADDDDABABBCBCACA");
        Assert.assertFalse(result);
    }
}
