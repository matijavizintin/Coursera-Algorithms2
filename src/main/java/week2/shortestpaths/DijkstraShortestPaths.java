package week2.shortestpaths;

import edu.princeton.cs.algs4.IndexMinPQ;
import week2.structures.edges.DirectedEdge;
import week2.structures.graphs.EdgeWeightedDirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 15:21
 */
public class DijkstraShortestPaths extends ShortestPaths {
    private IndexMinPQ<Double> verticesPQ;

    public DijkstraShortestPaths(EdgeWeightedDirectedGraph graph, int start) {
        super(graph, start, null);
    }

    @Override
    protected void initStructures() {
        super.initStructures();

        // init PQ
        verticesPQ = new IndexMinPQ<>(graph.V());
    }

    @Override
    protected void findShortestPaths() {
        // put initial vertex into the min PQ
        verticesPQ.insert(start, 0.);

        // loop until we visited all connected vertices
        while (!verticesPQ.isEmpty()) {
            int vertex = verticesPQ.delMin();

            // go through all adjacent
            for (DirectedEdge directedEdge : graph.adjacent(vertex)) {
                // relax the edge
                relax(directedEdge);
            }
        }
    }

    @Override
    protected boolean relax(DirectedEdge edge) {
        boolean relaxed = super.relax(edge);
        if (relaxed) {
            // update PQ
            int w = edge.to();
            if (verticesPQ.contains(w)) verticesPQ.decreaseKey(w, distTo[w]);
            else verticesPQ.insert(w, distTo[w]);

        }
        return relaxed;
    }
}
