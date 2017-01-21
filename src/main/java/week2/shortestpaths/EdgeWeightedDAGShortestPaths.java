package week2.shortestpaths;

import week2.structures.TopologicalSort;
import week2.structures.edges.DirectedEdge;
import week2.structures.graphs.EdgeWeightedDirectedGraph;

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
        // compute topologicalSort order of a DAG
        TopologicalSort topologicalSort = new TopologicalSort(graph);

        // go through vertices and relax adjacent
        for (Integer v : debugForcedTopological != null ? debugForcedTopological : topologicalSort.getOrder()) {
            for (DirectedEdge directedEdge : graph.adjacent(v)) {
                relax(directedEdge);
            }
        }
    }
}
