package week2;

import org.junit.Test;
import week2.mst.GreedyMST;
import week2.mst.KruskalMST;
import week2.mst.MST;
import week2.mst.PrimMST;
import week2.structures.edges.UndirectedEdge;
import week2.structures.graphs.EdgeWeightedUndirectedGraph;

/**
 * Created by matijav on 21/01/2017.
 */
public class MSTTest2 {

    @Test
    public void test11() {
        // build graph
        EdgeWeightedUndirectedGraph wg = buildGraph2();

        // compute mst
        System.out.println("Kruska");
        MST mst = new KruskalMST(wg);
        for (UndirectedEdge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println();
    }

    @Test
    public void test12() {
        // build graph
        EdgeWeightedUndirectedGraph wg = buildGraph2();

        // compute mst
        MST mst = new PrimMST(wg);
        System.out.println("Prim");
        for (UndirectedEdge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println();
    }

    @Test
    public void test13() {
        // build graph
        EdgeWeightedUndirectedGraph wg = buildGraph2();

        // compute mst
        MST mst = new GreedyMST(wg);
        System.out.println("Home-made :)");
        for (UndirectedEdge edge : mst.edges()) {
            System.out.println(edge);
        }
        System.out.println();
    }

    private EdgeWeightedUndirectedGraph buildGraph2() {
        EdgeWeightedUndirectedGraph graph = new EdgeWeightedUndirectedGraph(8);
        graph.addEdge(5, 1, 7);
        graph.addEdge(1, 3, 5);
        graph.addEdge(5, 7, 6);
        graph.addEdge(1, 7, 2);
        graph.addEdge(5, 4, 9);
        graph.addEdge(4, 6, 20);
        graph.addEdge(4, 0, 14);
        graph.addEdge(4, 7, 12);
        graph.addEdge(0, 6, 16);
        graph.addEdge(0, 2, 3);
        graph.addEdge(7, 0, 1);
        graph.addEdge(7, 2, 11);
        graph.addEdge(1, 2, 10);
        graph.addEdge(3, 2, 4);
        graph.addEdge(3, 6, 13);
        graph.addEdge(2, 6, 8);

        return graph;
    }
}
