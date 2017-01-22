package week2.shortestpaths;

import week2.structures.edges.DirectedEdge;
import week2.structures.graphs.EdgeWeightedDirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 18:15
 */
public class BellmanFordShortestPaths extends ShortestPaths {
    public BellmanFordShortestPaths(EdgeWeightedDirectedGraph graph, int start) {
        super(graph, start, null);
    }

    @Override
    protected void findShortestPaths() {
        for (int i = 0; i < graph.V(); i++) {
            for (int v = 0; v < graph.V(); v++) {
                for (DirectedEdge e : graph.adjacent(v)) {
                    relax(e);
                }
            }

            if (debug) {
                System.out.printf("Printing distTo after pass %d\n", i);
                debugPrintDist();
            }
        }
    }
}
