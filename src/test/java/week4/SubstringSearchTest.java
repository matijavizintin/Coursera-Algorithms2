package week4;

import org.junit.Assert;
import org.junit.Test;
import week4.substringsearch.BoyerMoore;
import week4.substringsearch.BruteForce;
import week4.substringsearch.KnuthMorrisPratt;
import week4.substringsearch.RabinKarp;

/**
 * Created by matijav on 05/02/2017.
 */
public class SubstringSearchTest {

    @Test
    public void testBruteForce1() {
        String input = generateInput();
        String pattern = "fringilla";
        int res = BruteForce.search(pattern, input);
        Assert.assertEquals(input.length() - pattern.length() - 1, res);

        String input2 = generateInput2();
        pattern = "aaaab";
        res = BruteForce.search(pattern, input2);
        Assert.assertEquals(input2.length() - pattern.length(), res);

        pattern = "missmatch";
        res = BruteForce.search(pattern, input);
        Assert.assertEquals(input.length(), res);
    }

    @Test
    public void testBruteForce2() {
        String input = generateInput();
        String pattern = "fringilla";
        int res = BruteForce.search2(pattern, input);
        Assert.assertEquals(input.length() - pattern.length() - 1, res);

        String input2 = generateInput2();
        pattern = "aaaab";
        res = BruteForce.search2(pattern, input2);
        Assert.assertEquals(input2.length() - pattern.length(), res);

        pattern = "missmatch";
        res = BruteForce.search(pattern, input);
        Assert.assertEquals(input.length(), res);
    }

    @Test
    public void testKMP() {
        String input = generateInput();
        String pattern = "fringilla";
        int res = new KnuthMorrisPratt(pattern).search(input);
        Assert.assertEquals(input.length() - pattern.length() - 1, res);

        String input2 = generateInput2();
        pattern = "aaaab";
        res = new KnuthMorrisPratt(pattern).search(input2);
        Assert.assertEquals(input2.length() - pattern.length(), res);

        pattern = "missmatch";
        res = new KnuthMorrisPratt(pattern).search(input);
        Assert.assertEquals(input.length(), res);
    }

    @Test
    public void testBM() {
        String input = generateInput();
        String pattern = "fringilla";
        int res = new BoyerMoore(pattern).search(input);
        Assert.assertEquals(input.length() - pattern.length() - 1, res);

        String input2 = generateInput2();
        pattern = "aaaab";
        res = new BoyerMoore(pattern).search(input2);
        Assert.assertEquals(input2.length() - pattern.length(), res);

        pattern = "missmatch";
        res = new BoyerMoore(pattern).search(input);
        Assert.assertEquals(input.length(), res);

        String input3 = generateInput3(100 * 1000 * 1000);
        pattern = "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        res = new BoyerMoore(pattern).search(input3);
        Assert.assertEquals(input3.length(), res);
    }

    @Test
    public void testRK() {
        String input = generateInput();
        String pattern = "fringilla";
        int res = new RabinKarp(pattern).search(input);
        Assert.assertEquals(input.length() - pattern.length() - 1, res);

        String input2 = generateInput2();
        pattern = "aaaab";
        res = new RabinKarp(pattern).search(input2);
        Assert.assertEquals(input2.length() - pattern.length(), res);

        pattern = "missmatch";
        res = new RabinKarp(pattern).search(input);
        Assert.assertEquals(input.length(), res);

        String input3 = generateInput3(100 * 1000 * 1000);
        pattern = "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        res = new RabinKarp(pattern).search(input3);
        Assert.assertEquals(input3.length(), res);
    }

    private String generateInput() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eros quam, sollicitudin in dictum at, volutpat ut nisi. Cras ornare lacinia dapibus. Nam facilisis ipsum vitae nunc scelerisque, id bibendum libero imperdiet. Praesent id consectetur dolor. Duis commodo, odio eget vestibulum aliquam, tortor ipsum finibus est, at tincidunt tellus mi quis nisi. Morbi egestas velit leo. Suspendisse elementum lorem mauris, ut gravida orci tempor euismod. In at ligula sapien. Etiam sed quam tempor, malesuada diam ac, commodo leo. Donec faucibus et massa vel convallis. Praesent rhoncus venenatis dui quis semper. In accumsan elit sapien, sit amet vestibulum nisl luctus fringilla.";
    }

    private String generateInput2() {
        return "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    }

    private String generateInput3(int size) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append('b');
        }
        return sb.toString();
    }
}
