package week2;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import week2.structures.edges.DirectedEdge;
import week2.structures.graphs.EdgeWeightedDirectedGraph;
import week2.shortestpaths.BellmanFordShortestPaths;
import week2.shortestpaths.DijkstraShortestPaths;
import week2.shortestpaths.EdgeWeightedDAGShortestPaths;
import week2.shortestpaths.ShortestPaths;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 13:12
 */
public class ShortestPathsTest {

    @Test
    public void test1() {
        ShortestPaths sp = new DijkstraShortestPaths(buildGraph(), 0);
        print(sp);
    }

    @Test
    public void dijkstraCorrectnessTest() {
        ShortestPaths sp = new DijkstraShortestPaths(buildGraph2(), 0);
        print(sp);
    }

    @Test       // NOTE: it works but it's not optimal
    public void dijkstraNegativeTest() {
        EdgeWeightedDirectedGraph graph = new EdgeWeightedDirectedGraph(4);
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 6);
        graph.addEdge(2, 3, -9);
        graph.addEdge(0, 3, 2);
        ShortestPaths sp = new DijkstraShortestPaths(graph, 0);
        print(sp);

        // compare with others
        compareSP(sp, new EdgeWeightedDAGShortestPaths(graph, 0));
        compareSP(sp, new BellmanFordShortestPaths(graph, 0));
    }

    @Test
    public void dagSPTest() {
        EdgeWeightedDAGShortestPaths sp = new EdgeWeightedDAGShortestPaths(buildGraph2(), 0);
        print(sp);

        // compare with dijkstra
        compareSP(sp, new DijkstraShortestPaths(buildGraph2(), 0));
    }

    @Test
    public void bellmanFordTest() {
        ShortestPaths sp = new BellmanFordShortestPaths(buildGraph3(), 0);
        print(sp);

        // compare with dijkstra and EWDAGSP
        compareSP(sp, new DijkstraShortestPaths(buildGraph3(), 0));
        compareSP(sp, new EdgeWeightedDAGShortestPaths(buildGraph3(), 0));
    }

    // build graph
    private EdgeWeightedDirectedGraph buildGraph() {
        EdgeWeightedDirectedGraph graph = new EdgeWeightedDirectedGraph(8);
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

    private EdgeWeightedDirectedGraph buildGraph2() {
        EdgeWeightedDirectedGraph graph = new EdgeWeightedDirectedGraph(8);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 4, 9);
        graph.addEdge(0, 7, 8);
        graph.addEdge(4, 7, 5);
        graph.addEdge(4, 5, 4);
        graph.addEdge(4, 6, 20);
        graph.addEdge(1, 7, 4);
        graph.addEdge(7, 5, 6);
        graph.addEdge(5, 2, 1);
        graph.addEdge(7, 2, 7);
        graph.addEdge(5, 6, 13);
        graph.addEdge(2, 6, 11);
        graph.addEdge(3, 6, 9);
        graph.addEdge(1, 3, 15);
        graph.addEdge(1, 2, 12);
        graph.addEdge(2, 3, 3);

        return graph;
    }

    private EdgeWeightedDirectedGraph buildGraph3() {
        EdgeWeightedDirectedGraph graph = new EdgeWeightedDirectedGraph(8);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 4, 9);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 12);
        graph.addEdge(1, 3, 15);
        graph.addEdge(1, 7, 4);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 6, 11);
        graph.addEdge(3, 6, 9);
        graph.addEdge(4, 5, 4);
        graph.addEdge(4, 6, 20);
        graph.addEdge(4, 7, 5);
        graph.addEdge(5, 2, 1);
        graph.addEdge(5, 6, 13);
        graph.addEdge(7, 5, 6);
        graph.addEdge(7, 2, 7);

        return graph;
    }

    private void print(ShortestPaths sp) {
        for (int i = 0; i < sp.V(); i++) {
            double dist = sp.distTo(i);
            System.out.printf("dist to %d = %f\n", i, dist);
            System.out.printf("hasPath to %d = %b\n", i, sp.hasPathTo(i));
            Iterable<DirectedEdge> path = sp.pathTo(i);
            for (DirectedEdge directedEdge : path) {
                System.out.println(directedEdge);
            }
            System.out.println();
        }
    }

    private void compareSP(ShortestPaths sp1, ShortestPaths sp2) {
        Assert.assertEquals(sp1.V(), sp2.V());
        for (int i = 0; i < sp1.V(); i++) {
            double d1 = sp1.distTo(i);
            double d2 = sp2.distTo(i);
            Assert.assertEquals(d1, d2, Math.pow(10, -9));

            // assert path
            Assert.assertEquals(sp1.hasPathTo(i), sp2.hasPathTo(i));
            assertIterable(sp1.pathTo(i), sp2.pathTo(i));
        }
    }

    private void assertIterable(Iterable<DirectedEdge> i1, Iterable<DirectedEdge> i2) {
        Assert.assertArrayEquals(Iterables.toArray(i1, DirectedEdge.class), Iterables.toArray(i2, DirectedEdge.class));
    }
}
