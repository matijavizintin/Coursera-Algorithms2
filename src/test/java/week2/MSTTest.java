package week2;

import org.junit.Test;
import week2.mst.KruskalMST;
import week2.mst.PrimMST;
import week2.mst.graphs.Edge;
import week2.mst.graphs.EdgeWightedGraph;

/**
 * Created by Matija Vižintin
 * Date: 29. 11. 2015
 * Time: 16:41
 */
public class MSTTest {

    @Test
    public void test1() {
        // build graph
        EdgeWightedGraph wg = buildGraph();

        // compute mst
        KruskalMST mst = new KruskalMST(wg);
        for (Edge edge : mst.edges()) {
            System.out.println(edge);
        }
    }

    @Test
    public void test2() {
        // build graph
        EdgeWightedGraph wg = buildGraph();

        // compute mst
        PrimMST mst = new PrimMST(wg);
        for (Edge edge : mst.edges()) {
            System.out.println(edge);
        }
    }

    // build graph
    private EdgeWightedGraph buildGraph() {
        EdgeWightedGraph graph = new EdgeWightedGraph(8);
        graph.addEdge(0, 7, 0.16);
        graph.addEdge(2, 3, 0.17);
        graph.addEdge(1, 7, 0.19);
        graph.addEdge(0, 2, 0.26);
        graph.addEdge(1, 3, 0.29);
        graph.addEdge(1, 5, 0.32);
        graph.addEdge(2, 7, 0.34);
        graph.addEdge(4, 5, 0.35);
        graph.addEdge(1, 2, 0.36);
        graph.addEdge(4, 7, 0.37);
        graph.addEdge(0, 4, 0.38);
        graph.addEdge(6, 2, 0.40);
        graph.addEdge(3, 6, 0.52);
        graph.addEdge(6, 0, 0.58);
        graph.addEdge(6, 4, 0.93);

        return graph;
    }
}
