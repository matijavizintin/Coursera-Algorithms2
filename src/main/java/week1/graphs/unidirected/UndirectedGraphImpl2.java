package week1.graphs.unidirected;

import java.io.InputStream;
import java.util.LinkedList;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:30
 */
public class UndirectedGraphImpl2 implements UndirectedGraph<Integer> {
    private final int verticesCount;
    private int edgesCount = 0;

    private LinkedList<Integer>[] adj;

    public UndirectedGraphImpl2(int v) {
        verticesCount = v;
        adj = (LinkedList<Integer>[]) new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public UndirectedGraphImpl2(InputStream in) {
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
    public int V() {
        return verticesCount;
    }

    // number of edges
    public int E() {
        return edgesCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v = 0; v < V(); v++) {
            for (Integer w : adjacent(v)) {
                stringBuilder.append(v).append(" - ").append(w).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void injectAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }
}
