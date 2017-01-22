package week2.shortestpaths;

import week2.structures.edges.DirectedEdge;
import week2.structures.graphs.EdgeWeightedDirectedGraph;

import java.util.List;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 16:16
 *
 * Works on graphs with no cycles --> DAG because is based on topological order
 */
public class EdgeWeightedDAGShortestPaths extends ShortestPaths {
    private List<Integer> debugForcedTopological;

    public EdgeWeightedDAGShortestPaths(EdgeWeightedDirectedGraph graph, int start, List<Integer> debugForcedTopological) {
        super(graph, start, debugForcedTopological);
    }

    @Override
    protected void findShortestPaths() {
        // compute topologicalSort order of a DAG
        Iterable<Integer> topologicalOrder;
        if (debugForcedTopological != null) {
            topologicalOrder = debugForcedTopological;
        } else {
            topologicalOrder = new TopologicalSort(graph).getOrder();
        }

        // go through vertices and relax adjacent
        for (Integer v : topologicalOrder) {
            for (DirectedEdge directedEdge : graph.adjacent(v)) {
                relax(directedEdge);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void hook(Object param) {
        this.debugForcedTopological = (List<Integer>)param;
    }
}
