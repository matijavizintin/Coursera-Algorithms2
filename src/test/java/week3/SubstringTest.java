package week3;

import org.junit.Assert;
import org.junit.Test;
import week3.radix.substring.Substring;

/**
 * Created by matijav on 28/01/2017.
 */
public class SubstringTest {

    @Test
    public void testSubstringing() {
        String input = "Hello world!";

        Substring ss1 = new Substring(input, 0, 5);
        String expected1 = "Hello";
        Assert.assertEquals(expected1, ss1.asString());

        Substring ss2 = new Substring(input, 6, 11);
        String expected2 = "world";
        Assert.assertEquals(expected2, ss2.asString());

        Substring ss3 = new Substring(input, 8, 8);
        String expected3 = "";
        Assert.assertEquals(expected3, ss3.asString());
    }

    @Test
    public void testLength() {
        String input = "Hello world!";

        Substring ss1 = new Substring(input, 0, 5);
        int expected1 = 5;
        Assert.assertEquals(expected1, ss1.length());

        Substring ss2 = new Substring(input, 6, input.length());
        int expected2 = 6;
        Assert.assertEquals(expected2, ss2.length());

        Substring ss3 = new Substring(input, 0, input.length());
        int expected3 = input.length();
        Assert.assertEquals(expected3, ss3.length());

        Substring ss4 = new Substring(input, 0, 0);
        int expected4 = 0;
        Assert.assertEquals(expected4, ss4.length());
    }

    @Test
    public void testChartAt() {
        String input = "Hello world!";

        char ch1 = input.charAt(0);
        char expected1 = 'H';
        Assert.assertEquals(expected1, ch1);

        char ch2 = input.charAt(5);
        char expected2 = ' ';
        Assert.assertEquals(expected2, ch2);

        char ch3 = input.charAt(input.length() - 1);
        char expected3 = '!';
        Assert.assertEquals(expected3, ch3);
    }
}
