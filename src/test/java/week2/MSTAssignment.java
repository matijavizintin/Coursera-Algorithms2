package week2;

import org.junit.Test;
import week2.structures.graphs.EdgeWeightedUndirectedGraph;
import week2.structures.edges.UndirectedEdge;
import week2.mst.KruskalMST;
import week2.mst.PrimMST;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 11:09
 */
public class MSTAssignment {

    @Test
    public void quiz1() {
        EdgeWeightedUndirectedGraph edgeWightedGraph = createGraph();
        KruskalMST mst = new KruskalMST(edgeWightedGraph);
        for (UndirectedEdge edge : mst.edges()) {
            System.out.printf("%.0f ", edge.weight());
        }
    }

    @Test
    public void quiz2() {
        EdgeWeightedUndirectedGraph edgeWightedGraph = createGraph2();
        PrimMST mst = new PrimMST(edgeWightedGraph, 1);     // define start node
        for (UndirectedEdge edge : mst.edges()) {
            System.out.printf("%.0f ", edge.weight());
        }
    }

    private EdgeWeightedUndirectedGraph createGraph() {
        String s = "F-A    17\n" +
                   "    A-B    16\n" +
                   "    B-C    10\n" +
                   "    H-B     7\n" +
                   "    G-B     6\n" +
                   "    F-B     3\n" +
                   "    D-C     5\n" +
                   "    C-H     4\n" +
                   "    E-D    12\n" +
                   "    I-D    11\n" +
                   "    D-H     2\n" +
                   "    J-E    14\n" +
                   "    I-E    13\n" +
                   "    G-F     1\n" +
                   "    G-H     8\n" +
                   "    I-H     9\n" +
                   "    J-I    15\n";

        return GraphBuilderHelper.convertToGraph(s, "-", new EdgeWeightedUndirectedGraph(10));
    }

    private EdgeWeightedUndirectedGraph createGraph2() {
        String s = "A-B      16\n" +
                   "    A-F       8\n" +
                   "    A-G       2\n" +
                   "    G-B      15\n" +
                   "    B-C      14\n" +
                   "    H-B      12\n" +
                   "    C-H      13\n" +
                   "    C-D       5\n" +
                   "    E-D      11\n" +
                   "    D-H      10\n" +
                   "    D-I       6\n" +
                   "    E-J       7\n" +
                   "    I-E       4\n" +
                   "    F-G       3\n" +
                   "    G-H       9\n" +
                   "    I-H       1\n" +
                   "    I-J      17\n";

        return GraphBuilderHelper.convertToGraph(s, "-", new EdgeWeightedUndirectedGraph(10));
    }
}
