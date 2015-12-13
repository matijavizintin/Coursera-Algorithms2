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
        String s = "A->B     17  /  17\n" +
                "    A->F     10  /  20\n" +
                "    A->G     30  /  30\n" +
                "    B->C     25  /  26\n" +
                "    C->D     10  /  19\n" +
                "    C->G      8  /   8\n" +
                "    C->H      7  /   9\n" +
                "    D->E      5  /   5\n" +
                "    D->I      0  /  11\n" +
                "    D->J     27  /  42\n" +
                "    E->J      5  /   5\n" +
                "    F->G     10  /  18\n" +
                "    G->B      8  /   8\n" +
                "    G->H     40  /  40\n" +
                "    H->D     22  /  22\n" +
                "    H->I     25  /  25\n" +
                "    I->J     25  /  25";


        return NetworkBuilderHelper.convertToNetwork(s, "->", 10);
    }

    public FlowNetwork createNetwork1() {
        String s = "A->F      8  /   8\n" +
                "    A->G      9  /  18\n" +
                "    A->B      9  /  12\n" +
                "    B->C      9  /   9\n" +
                "    B->G      0  /  10\n" +
                "    G->C      3  /   3\n" +
                "    C->D     12  /  15\n" +
                "    C->H      0  /   5\n" +
                "    D->H      0  /   6\n" +
                "    D->E      6  /   6\n" +
                "    D->I      4  /  14\n" +
                "    D->J      2  /  13\n" +
                "    E->J      6  /  10\n" +
                "    F->G      8  /   9\n" +
                "    G->H     14  /  16\n" +
                "    H->I     14  /  14\n" +
                "    I->J     18  /  18";
        return NetworkBuilderHelper.convertToNetwork(s, "->", 10);
    }
}
