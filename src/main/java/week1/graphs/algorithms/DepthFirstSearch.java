package week1.graphs.algorithms;

import week1.graphs.Graph;

/**
 * Created by Matija Vižintin
 * Date: 08. 11. 2015
 * Time: 19:35
 */
public class DepthFirstSearch {
    private Graph<Integer> graph;

    public boolean[] marked;        // getters for arrays are so annoying
    public int[] edgeTo;
    public int[] preOrder;
    private int index;

    public DepthFirstSearch(Graph<Integer> graph, int source) {
        this.graph = graph;

        // init structures
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        preOrder = new int[graph.V()];
        index = 0;

        depthFirstSearch(source);
    }

    private void depthFirstSearch(int vertex) {
        // set visited
        marked[vertex] = true;
        preOrder[index++] = vertex;

        // go through all adjacent
        Iterable<Integer> adjacent = graph.adjacent(vertex);
        for (Integer adj : adjacent) {
            // if not marked recursively go into vertex
            if (!marked[adj]) {
                depthFirstSearch(adj);
                edgeTo[adj] = vertex;
            }
        }
    }
}
