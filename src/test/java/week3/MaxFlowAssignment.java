package week3;

import org.junit.Test;
import week3.graphs.FlowNetwork;
import week3.maxflow.FordFulkerson;

/**
 * Created by Matija Vižintin
 * Date: 13. 12. 2015
 * Time: 21:45
 */
public class MaxFlowAssignment {

    @Test
    public void test1() {
        FordFulkerson ff = new FordFulkerson(createNetwork(), NetworkBuilderHelper.nodesMap.inverse().get("A"), NetworkBuilderHelper.nodesMap.inverse().get("J"));

        for (Integer integer : ff.debug) {
            System.out.print(NetworkBuilderHelper.nodesMap.get(integer) + " ");
        }
    }

    @Test
    public void test2() {
        FordFulkerson ff = new FordFulkerson(createNetwork1(), NetworkBuilderHelper.nodesMap.inverse().get("A"), NetworkBuilderHelper.nodesMap.inverse().get("J"));
        for (int i = 0; i < 10; i++) {
            boolean incut = ff.inCut(i);
            if (incut) {
                System.out.print(NetworkBuilderHelper.nodesMap.get(i) + " ");
            }
        }
    }

    public FlowNetwork createNetwork() {
        String s = "A->B     23  /  32\n" +
                "    A->F      5  /  12\n" +
                "    A->G      0  /   5\n" +
                "    B->C      0  /   7\n" +
                "    B->G      0  /  14\n" +
                "    B->H     23  /  26\n" +
                "    C->D      9  /   9\n" +
                "    C->H      0  /   7\n" +
                "    D->E     10  /  12\n" +
                "    D->J      6  /   9\n" +
                "    E->J     10  /  10\n" +
                "    F->G      5  /   6\n" +
                "    G->H      5  /   5\n" +
                "    H->I     28  /  28\n" +
                "    I->C      9  /  13\n" +
                "    I->D      7  /   7\n" +
                "    I->J     12  /  30";


        return NetworkBuilderHelper.convertToNetwork(s, "->", 10);
    }

    public FlowNetwork createNetwork1() {
        String s = "A->B      37  /   37\n" +
                "    A->F      11  /  11\n" +
                "    A->G      16  /  29\n" +
                "    B->C      37  /   40\n" +
                "    B->G      0  /  7\n" +
                "    C->I      10  /   10\n" +
                "    C->G     0  /  9\n" +
                "    C->H      1  /   8\n" +
                "    C->D      26  /   29\n" +
                "    I->D      0 /   11\n" +
                "    D->E      9  /   9\n" +
                "    D->J      17  /  18\n" +
                "    E->J      9  /  10\n" +
                "    F->G      11  /   11\n" +
                "    G->H     27  /  27\n" +
                "    H->I     28  /  28\n" +
                "    I->J     38  /  39";
        return NetworkBuilderHelper.convertToNetwork(s, "->", 10);
    }
}
