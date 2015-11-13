package week1.graphs.algorithms.directed;

import week1.graphs.directed.DirectedGraph;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by Matija Vižintin
 * Date: 12. 11. 2015
 * Time: 19:30
 */
public class DepthFirstOrder {
    private DirectedGraph graph;

    public boolean[] marked;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(DirectedGraph graph) {
        this.graph = graph;

        // init structures
        marked = new boolean[graph.vertices()];
        reversePost = new Stack<>();


        // go through all unmarked nodes
        for (int i = 0; i < graph.vertices(); i++) {
            if (!marked[i]) {
                depthFirstSearch(i);
            }
        }

        // reverse order - stack's iterator doesn't do that
        Collections.reverse(reversePost);
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
        reversePost.add(vertex);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
