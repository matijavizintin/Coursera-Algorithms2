package week4;

import org.junit.Test;
import week4.substringsearch.BoyerMoore;
import week4.substringsearch.KnuthMorrisPratt;

/**
 * Created by matijav on 05/02/2017.
 */
public class SubstringSearchAssignment {

    @Test
    public void test1() {
        KnuthMorrisPratt kmp = new KnuthMorrisPratt("CBCBCACC");
        kmp.debugChar = 'B';

        kmp.debugPrint();
    }

    @Test
    public void test2() {
        BoyerMoore bm = new BoyerMoore("FMYSELF");
        bm.debug = true;
        bm.search("UPTOSOHOANDOFFERMYSELFMYSELFST");
    }

    @Test
    public void test3() {
        int R = 10;
        long Q = 79;
        int RM = 62;
        int M = 9;
        int i = 13;

        String text = "2759943????686472207";

        long textHash = 36;
        textHash = (textHash + Q - RM * text.charAt(i - M) % Q) % Q;    // remove first char from hash
        textHash = (textHash * R + text.charAt(i)) % Q;

        System.out.println(textHash);

    }
}
