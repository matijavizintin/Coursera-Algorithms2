package week1.graphs.algorithms;

import week1.graphs.Graph;

/**
 * Created by Matija Vižintin
 * Date: 08. 11. 2015
 * Time: 19:35
 */
public class DepthFirstSearch {
    private Graph graph;
    private int source;

    public boolean[] marked;        // getters for arrays are so annoying
    public int[] edgeTo;

    public DepthFirstSearch(Graph graph, int source) {
        this.graph = graph;
        this.source = source;

        // init structures
        marked = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];

        depthFirstSearch(source);
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
                edgeTo[adj] = vertex;
            }
        }
    }
}
