package week1.graphs;

import java.io.InputStream;
import java.util.LinkedList;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:30
 */
public class Graph2 implements Graph {
    private final int verticesCount;
    private int edgesCount = 0;

    private LinkedList<Integer>[] adj;

    public Graph2(int v) {
        verticesCount = v;
        adj = (LinkedList<Integer>[]) new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public Graph2(InputStream in) {
        verticesCount = 0;
    }

    // add an edge from v to w
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // vertices adjacent to v
    public Iterable<Integer> adjacent(int v) {
        return adj[v];
    }

    // number of vertices
    public int vertices() {
        return verticesCount;
    }

    // number of edges
    public int edges() {
        return edgesCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v = 0; v < vertices(); v++) {
            for (Integer w : adjacent(v)) {
                stringBuilder.append(v).append(" - ").append(w).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
