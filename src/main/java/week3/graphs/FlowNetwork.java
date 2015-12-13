package week3.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Matija Vižintin
 * Date: 13. 12. 2015
 * Time: 18:44
 */
public class FlowNetwork {
    private final int vertices;
    private List<FlowEdge>[] adj;
    private int edges;

    public FlowNetwork(int v) {
        vertices = v;

        // int adj
        adj = (List<FlowEdge>[])new List[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(FlowEdge flowEdge) {
        adj[flowEdge.from()].add(flowEdge);
        adj[flowEdge.to()].add(flowEdge);
        edges++;
    }

    public Iterable<FlowEdge> adjacent(int v) {
        return adj[v];
    }

    public Iterable<FlowEdge> edges() {
        return Stream.of(adj).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public int V() {
        return vertices;
    }

    public int E() {
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlowNetwork with ").append(vertices).append(" vertices and ").append(edges).append(" edges.\n");

        for (int i = 0; i < vertices; i++) {
            sb.append("Edges for vertex ").append(i).append(":\n");
            for (FlowEdge flowEdge : adjacent(i)) {
                sb.append(flowEdge).append("\n");
            }
        }
        return sb.toString();
    }
}
