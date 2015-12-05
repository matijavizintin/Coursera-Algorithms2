package week2.shortestpaths;

import week2.graphs.DirectedEdge;
import week2.graphs.EdgeWeightedDirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 15:21
 */
public class DijkstraShortestPaths extends ShortestPaths {

    public DijkstraShortestPaths(EdgeWeightedDirectedGraph graph, int start) {
        super(graph, start);
    }

    @Override
    protected void findShortestPaths() {
        // put initial vertex into the min PQ
        verticesPQ.insert(start, 0.);

        // loop until we visited all connected vertices
        while (!verticesPQ.isEmpty()) {
            int vertex = verticesPQ.delMin();

            // go through all adjacent
            for (DirectedEdge directedEdge : graph.adj(vertex)) {
                // relax the edge
                relax(directedEdge);
            }
        }
    }
}
