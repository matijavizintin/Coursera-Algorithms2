package week2.structures;

import edu.princeton.cs.algs4.Stack;
import week1.graphs.directed.DirectedGraph;
import week2.structures.edges.DirectedEdge;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 16:32
 */
public class TopologicalSort {
    private DirectedGraph<DirectedEdge> graph;
    private boolean[] marked;
    private Stack<Integer> order;

    public TopologicalSort(DirectedGraph<DirectedEdge> graph) {
        this.graph = graph;

        // init structures
        marked = new boolean[graph.V()];
        order = new Stack<>();

        // go through all unmarked nodes and run DFS
        for (int i = 0; i < graph.V(); i++) {
            if (!marked[i]) {
                depthFirstSearch(i);
            }
        }
    }

    private void depthFirstSearch(int vertex) {
        // set visited
        marked[vertex] = true;

        // go through all adjacent
        for (DirectedEdge adj : graph.adjacent(vertex)) {
            int w = adj.to();
            // if not marked recursively go into vertex
            if (!marked[w]) {
                depthFirstSearch(w);
            }
        }

        // push to stack
        order.push(vertex);
    }

    public Iterable<Integer> getOrder() {
        return order;
    }
}
