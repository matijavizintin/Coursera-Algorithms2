package week1.graphs.algorithms.directed;

import edu.princeton.cs.algs4.Stack;
import week1.graphs.directed.DirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 12. 11. 2015
 * Time: 19:30
 */
public class DepthFirstOrder {
    private DirectedGraph<Integer> graph;

    public boolean[] marked;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(DirectedGraph<Integer> graph) {
        this.graph = graph;

        // init structures
        marked = new boolean[graph.V()];
        reversePost = new Stack<>();

        // go through all unmarked nodes
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
        for (Integer adj : graph.adjacent(vertex)) {
            // if not marked recursively go into vertex
            if (!marked[adj]) {
                depthFirstSearch(adj);
            }
        }

        // push to stack
        reversePost.push(vertex);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
