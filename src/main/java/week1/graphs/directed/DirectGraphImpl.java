package week1.graphs.directed;

import java.util.LinkedList;

/**
 * Created by Matija Vižintin
 * Date: 10. 11. 2015
 * Time: 21:13
 */
public class DirectGraphImpl implements DirectedGraph<Integer> {
    private int vertices;
    private int edges;
    private LinkedList<Integer>[] adjacent;

    public DirectGraphImpl(int vertices) {
        this.vertices = vertices;
        this.edges = 0;

        adjacent = (LinkedList<Integer>[])new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacent[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        adjacent[v].add(w);
        edges++;
    }

    @Override
    public Iterable<Integer> adjacent(int v) {
        return adjacent[v];
    }

    @Override
    public int V() {
        return vertices;
    }

    @Override
    public int E() {
        return edges;
    }

    @Override
    public DirectedGraph<Integer> reverse() {
        DirectedGraph<Integer> reverseGraph = new DirectGraphImpl(vertices);
        for (int v = 0; v < vertices; v++) {
            for (Integer w : adjacent[v]) {
                reverseGraph.addEdge(w, v);
            }
        }
        return reverseGraph;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v = 0; v < vertices; v++) {
            for (Integer w : adjacent(v)) {
                stringBuilder.append(v).append(" -> ").append(w).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void injectAdj(LinkedList<Integer>[] adj) {
        this.adjacent = adj;
    }
}
