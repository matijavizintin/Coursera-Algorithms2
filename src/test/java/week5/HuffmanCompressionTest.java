package week5;

import org.junit.Assert;
import org.junit.Test;
import week5.datacompression.HuffmanCompression;

/**
 * Created by matijav on 12/02/2017.
 */
public class HuffmanCompressionTest {

    @Test
    public void test() {
        char[] input = "Hello world!".toCharArray();

        HuffmanCompression hc = new HuffmanCompression();
        hc.buildTrie(input);

        byte[] compressed = hc.compress(input);
        char[] expanded = hc.expand(compressed);
        Assert.assertArrayEquals(input, expanded);
    }
}
