package week2;

import org.junit.Test;
import week2.graphs.DirectedEdge;
import week2.graphs.EdgeWeightedDirectedGraph;
import week2.shortestpaths.ShortestPaths;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 13:12
 */
public class ShortestPathsTest {

    @Test
    public void test1() {
        ShortestPaths sp = new ShortestPaths(buildGraph(), 0);

        for (int i = 0; i < 8; i++) {
            double dist = sp.distTo(i);
            System.out.printf("dist to %d = %f\n", i, dist);
            System.out.printf("hasPath to %d = %b\n", i, sp.hasPathTo(i));
            Iterable<DirectedEdge> path = sp.pathTo(i);
            for (DirectedEdge directedEdge : path) {
                System.out.println(directedEdge);
            }
        }
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
}
