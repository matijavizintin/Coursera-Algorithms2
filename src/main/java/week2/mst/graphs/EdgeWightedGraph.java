package week2.mst.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Matija Vižintin
 * Date: 30. 11. 2015
 * Time: 21:01
 */
public class EdgeWightedGraph {
    private final int vertices;
    private int edges;
    private final LinkedList<Edge>[] adj;

    public EdgeWightedGraph(int vertices) {
        this.vertices = vertices;

        // init adjacent
        this.adj = (LinkedList<Edge>[])new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // helper method that creates the edge object
    public void addEdge(int v, int w, double weight) {
        addEdge(new Edge(v, w, weight));
    }

    // inserts a undirected edge into the graph
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        edges++;
    }

    // all edges adjacent to v
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    // all edges in the graph
    public Iterable<Edge> edges() {
        Set<Edge> edges = new HashSet<>();
        for (LinkedList<Edge> ll : adj) {
            for (Edge edge : ll) {
                edges.add(edge);
            }
        }
        return edges;
    }

    public int V() {
        return vertices;
    }

    public int E() {
        return edges;
    }
}
