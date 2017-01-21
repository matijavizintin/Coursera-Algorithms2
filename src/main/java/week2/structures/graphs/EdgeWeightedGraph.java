package week2.structures.graphs;

import week2.structures.edges.Edge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Matija Vižintin
 * Date: 30. 11. 2015
 * Time: 21:01
 */
public abstract class EdgeWeightedGraph<E extends Edge> {
    private final int vertices;
    protected int edges;
    protected final LinkedList<E>[] adj;

    public EdgeWeightedGraph(int vertices) {
        this.vertices = vertices;

        // init adjacent
        this.adj = (LinkedList<E>[])new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // helper method that creates the edge object
    public abstract void addEdge(int v, int w, double weight);

    // inserts a edge into the graph
    public abstract void addEdge(E e);

    // all edges adjacent to v
    public Iterable<E> adjacent(int v) {
        return adj[v];
    }

    // all edges in the graph
    public Iterable<E> edges() {
        Set<E> edges = new HashSet<>();
        for (LinkedList<E> list : adj) {
            edges.addAll(list.stream().collect(Collectors.toList()));
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
