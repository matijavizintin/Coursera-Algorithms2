package week5;

import org.junit.Assert;
import org.junit.Test;
import week5.datacompression.Compressor;

import java.io.ByteArrayOutputStream;

/**
 * Created by matijav on 12/02/2017.
 */
public class DataCompressionTest {
    /**
     * lgR = 4
     * <p>
     * 1 = 0001
     * 2 = 0010
     * 3 = 0011
     * 4 = 0100
     * 5 = 0101
     * 6 = 0110
     * 7 = 0111
     * 8 = 1000
     * 9 = 1001
     * 10 = 1010
     * 11 = 1011
     * 12 = 1100
     * 13 = 1101
     * 14 = 1110
     * 15 = 1111
     */

    @Test
    public void testRunLength1() {
        Compressor compressor = new Compressor(16, 4);
        byte[] input = new byte[]{1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};

        byte[] compressed = compressor.compress(input);
        byte[] expected = new byte[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1};
        Assert.assertArrayEquals(expected, compressed);

        byte[] expanded = compressor.expand(compressed);
        Assert.assertArrayEquals(input, expanded);
    }

    @Test
    public void testRunLength2() {
        Compressor compressor = new Compressor(256, 8);
        byte[] input = generateInput(new int[]{10, 100, 20, 300, 50, 24});
        byte[] compressed = compressor.compress(input);
        byte[] expectedCompressed = new byte[]{
                0, 0, 0, 0, 1, 0, 1, 0,     // 10
                0, 1, 1, 0, 0, 1, 0, 0,     // 100
                0, 0, 0, 1, 0, 1, 0, 0,     // 20
                1, 1, 1, 1, 1, 1, 1, 1,     // 255
                0, 0, 0, 0, 0, 0, 0, 0,     // 0
                0, 0, 1, 0, 1, 1, 0, 1,     // 45
                0, 0, 1, 1, 0, 0, 1, 0,     // 50
                0, 0, 0, 1, 1, 0, 0, 0};    // 24
        Assert.assertArrayEquals(expectedCompressed, compressed);

        byte[] expanded = compressor.expand(compressed);
        Assert.assertArrayEquals(input, expanded);
    }

    @Test
    public void testRunLengthPadding() {
        Compressor compressor = new Compressor(256, 8);
        byte[] input = generateInput(new int[]{10, 100, 20, 300, 50, 22});      // not padded
        byte[] compressed = compressor.compress(input);
        byte[] expectedCompressed = new byte[]{
                0, 0, 0, 0, 1, 0, 1, 0,     // 10
                0, 1, 1, 0, 0, 1, 0, 0,     // 100
                0, 0, 0, 1, 0, 1, 0, 0,     // 20
                1, 1, 1, 1, 1, 1, 1, 1,     // 255
                0, 0, 0, 0, 0, 0, 0, 0,     // 0
                0, 0, 1, 0, 1, 1, 0, 1,     // 45
                0, 0, 1, 1, 0, 0, 1, 0,     // 50
                0, 0, 0, 1, 0, 1, 1, 0};    // 22
        Assert.assertArrayEquals(expectedCompressed, compressed);

        byte[] expanded = compressor.expand(compressed);
        byte[] expectedExpanded = new byte[input.length + 2];
        System.arraycopy(input, 0, expectedExpanded, 0, input.length);
        Assert.assertArrayEquals(expectedExpanded, expanded);
    }

    @Test(expected = Compressor.InvalidByteException.class)
    public void testInvalid() {
        new Compressor(16, 4).compress(new byte[]{0, 1, 2});
    }

    private byte[] generateInput(int[] values) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        boolean bit = false;
        for (int i = 0; i < values.length; i++) {
            int count = values[i];
            for (int j = 0; j < count; j++) {
                os.write(bit ? 1 : 0);
            }
            bit = !bit;
        }

        return os.toByteArray();
    }
}
