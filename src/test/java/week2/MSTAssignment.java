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
                "    B-A    11\n" +
                "    G-A     9\n" +
                "    B-H    13\n" +
                "    C-B     5\n" +
                "    B-G     1\n" +
                "    D-C     4\n" +
                "    H-C     3\n" +
                "    D-E    14\n" +
                "    I-D    10\n" +
                "    H-D     2\n" +
                "    J-E     8\n" +
                "    E-I     7\n" +
                "    F-G    16\n" +
                "    G-H     6\n" +
                "    I-H    15\n" +
                "    I-J    12";

        return GraphBuilderHelper.convertToGraph(s, "-", new EdgeWeightedUndirectedGraph(10));
    }

    private EdgeWeightedUndirectedGraph createGraph2() {
        String s = "A-B      12\n" +
                "    G-A       4\n" +
                "    F-A       2\n" +
                "    C-B      11\n" +
                "    G-B      10\n" +
                "    H-B       1\n" +
                "    C-I      15\n" +
                "    C-D      14\n" +
                "    H-C       9\n" +
                "    D-I      13\n" +
                "    E-D       6\n" +
                "    E-J      17\n" +
                "    I-E       3\n" +
                "    F-G       8\n" +
                "    G-H      16\n" +
                "    H-I       7\n" +
                "    I-J       5";

        return GraphBuilderHelper.convertToGraph(s, "-", new EdgeWeightedUndirectedGraph(10));
    }
}
