package week3;

import org.junit.Test;
import week3.radix.LSDRadixSort;
import week3.radix.MSDRadixSort;
import week3.radix.ThreeWayQuickSort;

/**
 * Created by Matija Vižintin
 * Date: 20. 12. 2015
 * Time: 15:25
 */
public class RadixSortAssignment {

    @Test
    public void quiz1() {
        String input = "3113 2414 4244 4313 2341 1422 1344 4314 1434 1144";

        LSDRadixSort sort = new LSDRadixSort();
        sort.sort(parseString(input), 4);
    }

    @Test
    public void quiz2() {
        String input = "2441 1412 4423 1144 1324 1221 3233 3141 3241 4213 4231 3212 1243 1131 2433";

        MSDRadixSort sort = new MSDRadixSort();
        sort.sort(parseString(input));
    }

    @Test
    public void quiz3() {
        String input = "4436 2465 1356 5442 4224 5621 1445 4615 4255 4635";

        ThreeWayQuickSort sort = new ThreeWayQuickSort();
        sort.sort(parseString(input));
    }

    private String[] parseString(String input) {
        return input.split(" ");
    }
}
