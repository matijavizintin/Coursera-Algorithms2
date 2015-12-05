package week2.shortestpaths;

import week2.graphs.DirectedEdge;
import week2.graphs.EdgeWeightedDirectedGraph;
import week2.graphs.Topological;

import java.util.List;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 16:16
 */
public class EdgeWeightedDAGShortestPaths extends ShortestPaths {
    public EdgeWeightedDAGShortestPaths(EdgeWeightedDirectedGraph graph, int start) {
        super(graph, start);
    }

    public EdgeWeightedDAGShortestPaths(EdgeWeightedDirectedGraph graph, int start, List<Integer> debugForcedTopological) {
        super(graph, start, debugForcedTopological);
    }

    @Override
    protected void findShortestPaths() {
        // compute topological order of a DAG
        Topological topological = new Topological(graph);

        // go through vertices and relax adjacent
        for (Integer v : debugForcedTopological != null ? debugForcedTopological : topological.getOrder()) {
            for (DirectedEdge directedEdge : graph.adjacent(v)) {
                relax(directedEdge);
            }
        }
    }
}
