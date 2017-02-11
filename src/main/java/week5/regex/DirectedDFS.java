package week5.regex;

import week1.graphs.directed.DirectedGraph;

/**
 * Created by matijav on 11/02/2017.
 */
public class DirectedDFS {
    private final DirectedGraph<Integer> graph;
    private final boolean[] marked;

    public DirectedDFS(DirectedGraph<Integer> graph, int s) {
        this.graph = graph;
        this.marked = new boolean[graph.V()];

        depthFirstSearch(s);
    }

    public DirectedDFS(DirectedGraph<Integer> graph, Iterable<Integer> s) {
        this.graph = graph;
        this.marked = new boolean[graph.V()];

        depthFirstSearch(s);
    }

    public boolean marked(int v) {
        return marked[v];
    }

    private void depthFirstSearch(Iterable<Integer> vertices) {
        for (Integer vertex : vertices) {
            depthFirstSearch(vertex);
        }
    }

    private void depthFirstSearch(int vertex) {
        // set visited
        marked[vertex] = true;

        // go through all adjacent
        Iterable<Integer> adjacent = graph.adjacent(vertex);
        for (Integer adj : adjacent) {
            // if not marked recursively go into vertex
            if (!marked[adj]) {
                depthFirstSearch(adj);
            }
        }
    }
}
