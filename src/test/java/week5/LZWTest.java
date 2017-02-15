package week5;

import org.junit.Assert;
import org.junit.Test;
import week5.datacompression.LZW;

import java.util.List;

/**
 * Created by matijav on 15/02/2017.
 */
public class LZWTest {

    @Test
    public void test() {
        LZW lzw = new LZW(256, 16);

        String input = "Hello world!";
        List<Integer> compressed = lzw.compress(input);
        String decompressed = lzw.expand(compressed);
        Assert.assertEquals(input, decompressed);
    }
}
