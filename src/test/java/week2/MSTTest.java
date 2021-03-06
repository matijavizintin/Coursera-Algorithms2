package week2;

import org.junit.Test;
import week2.mst.GreedyMST;
import week2.mst.MST;
import week2.structures.graphs.EdgeWeightedUndirectedGraph;
import week2.structures.edges.UndirectedEdge;
import week2.mst.KruskalMST;
import week2.mst.PrimMST;

/**
 * Created by Matija Vižintin
 * Date: 29. 11. 2015
 * Time: 16:41
 */
public class MSTTest {

    @Test
    public void test1() {
        // build graph
        EdgeWeightedUndirectedGraph wg = buildGraph();

        // compute mst
        MST mst = new KruskalMST(wg);
        System.out.println("Kruska");
        for (UndirectedEdge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println();
    }

    @Test
    public void test2() {
        // build graph
        EdgeWeightedUndirectedGraph wg = buildGraph();

        // compute mst
        MST mst = new PrimMST(wg);
        System.out.println("Prim");
        for (UndirectedEdge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println();
    }

    @Test
    public void test3() {
        // build graph
        EdgeWeightedUndirectedGraph wg = buildGraph();

        // compute mst
        MST mst = new GreedyMST(wg);
        System.out.println("Home made");
        for (UndirectedEdge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println();
    }

    // build graph
    private EdgeWeightedUndirectedGraph buildGraph() {
        EdgeWeightedUndirectedGraph graph = new EdgeWeightedUndirectedGraph(8);
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
