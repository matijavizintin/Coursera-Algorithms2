package week5;

import org.junit.Assert;
import org.junit.Test;
import week5.datacompression.LZW;

/**
 * Created by matijav on 15/02/2017.
 */
public class LZWTest {

    @Test
    public void test() {
        LZW lzw = new LZW();

        String input = "Hello world!";
        byte[] compressed = lzw.compress(input);
        String decompressed = lzw.expand(compressed);
        Assert.assertEquals(input, decompressed);
    }
}
