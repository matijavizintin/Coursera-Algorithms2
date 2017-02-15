package week5;

import org.junit.Test;
import week5.datacompression.HuffmanCompression;
import week5.datacompression.LZW;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matijav on 15/02/2017.
 */
public class DataCompressionAssignmentTest {

    @Test
    public void test1() {
        char[] input = "IFOOQJQQOJOYYJYJOFJOQQJFOJFOFFFEIFQQJIOJOOOJOOFOOIJFFQIOFOOOOYFFJ".toCharArray();

        HuffmanCompression hc = new HuffmanCompression();
        hc.debug = true;


        hc.buildTrie(input);
        hc.compress(input);
        System.out.println(hc.debugCount);
    }

    @Test
    public void test2() {
        byte[] input = new byte[]{43, 42, 81, 41, 42, 82, 83, 41, 43, 84, 80};
        List<Integer> inp = new ArrayList<>();
        for (byte b : input) {
            inp.add(Integer.parseInt(Byte.toString(b), 16));
        }

        LZW lzw = new LZW(128, 8);
        String result = lzw.expand(inp);

        for (char c : result.toCharArray()) {
            System.out.print(c + " ");
        }
    }

    @Test
    public void test3() {
        String input = "BACCCCCBAACCCBA";

        LZW lzw = new LZW(128, 8);
        List<Integer> compressed = lzw.compress(input);

        for (int b : compressed) {
            String hex = Integer.toHexString(b);
            System.out.print(hex + " ");
        }

    }
}
