package week2.shortestpaths;

import week2.graphs.DirectedEdge;
import week2.graphs.EdgeWeightedDirectedGraph;
import week2.graphs.Topological;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 16:16
 */
public class EdgeWeightedDAGShortestPaths extends ShortestPaths {
    public EdgeWeightedDAGShortestPaths(EdgeWeightedDirectedGraph graph, int start) {
        super(graph, start);
    }

    @Override
    protected void findShortestPaths() {
        // compute topological order of a DAG
        Topological topological = new Topological(graph);

        // go through vertices and relax adjacent
        for (Integer v : topological.getOrder()) {
            for (DirectedEdge directedEdge : graph.adjacent(v)) {
                relax(directedEdge);
            }
        }
    }
}
