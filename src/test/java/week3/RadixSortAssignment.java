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
        String input = "4421 3123 1114 1413 2324 4341 2423 1121 3321 3114";

        LSDRadixSort.DEBUG = true;
        LSDRadixSort sort = new LSDRadixSort();
        sort.sort(parseString(input), 4);
    }

    @Test
    public void quiz2() {
        String input = "1241 1234 3211 1443 3332 2324 2411 1442 1324 1211 4224 4131 4314 4412 1311";

        MSDRadixSort.DEBUG = true;
        MSDRadixSort.DEBUG_PRINT_COUNT = 3;
        MSDRadixSort sort = new MSDRadixSort();
        sort.sort(parseString(input));
    }

    @Test
    public void quiz3() {
        String input = "4163 3245 4334 3662 6124 1432 6264 4341 6532 4464";

        ThreeWayQuickSort.DEBUG = true;
        ThreeWayQuickSort sort = new ThreeWayQuickSort();
        sort.sort(parseString(input));
    }

    private String[] parseString(String input) {
        return input.split(" ");
    }
}
