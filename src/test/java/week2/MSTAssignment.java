package week2;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;
import week2.graphs.EdgeWeightedUndirectedGraph;
import week2.graphs.UndirectedEdge;
import week2.mst.KruskalMST;
import week2.mst.PrimMST;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 11:09
 */
public class MSTAssignment {
    public static final BiMap<Integer, String> nodesMap = HashBiMap.create();

    static {
        nodesMap.put(0, "A");
        nodesMap.put(1, "B");
        nodesMap.put(2, "C");
        nodesMap.put(3, "D");
        nodesMap.put(4, "E");
        nodesMap.put(5, "F");
        nodesMap.put(6, "G");
        nodesMap.put(7, "H");
        nodesMap.put(8, "I");
        nodesMap.put(9, "J");
        nodesMap.put(10, "K");
        nodesMap.put(11, "L");
        nodesMap.put(12, "M");
        nodesMap.put(13, "N");
        nodesMap.put(14, "O");
        nodesMap.put(15, "P");
        nodesMap.put(16, "R");
    }

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

        return convertToGraph(s);
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

        return convertToGraph(s);
    }

    private EdgeWeightedUndirectedGraph convertToGraph(String input) {
        EdgeWeightedUndirectedGraph edgeWightedGraph = new EdgeWeightedUndirectedGraph(10);
        for (String s : input.split("\n")) {
            s = s.trim();
            char firstNode = s.charAt(0);
            char secondNode = s.charAt(2);
            double weight = Double.parseDouble(s.substring(3).trim());

            edgeWightedGraph.addEdge(nodesMap.inverse().get(String.valueOf(firstNode)), nodesMap.inverse().get(String.valueOf(secondNode)), weight);
        }
        return edgeWightedGraph;
    }
}
