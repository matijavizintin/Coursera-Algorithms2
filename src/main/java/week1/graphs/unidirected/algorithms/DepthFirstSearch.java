package week1.graphs.unidirected.algorithms;

import week1.graphs.unidirected.UnidirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 08. 11. 2015
 * Time: 19:35
 */
public class DepthFirstSearch {
    private UnidirectedGraph unidirectedGraph;

    public boolean[] marked;        // getters for arrays are so annoying
    public int[] edgeTo;

    public DepthFirstSearch(UnidirectedGraph unidirectedGraph, int source) {
        this.unidirectedGraph = unidirectedGraph;

        // init structures
        marked = new boolean[unidirectedGraph.vertices()];
        edgeTo = new int[unidirectedGraph.vertices()];

        depthFirstSearch(source);
    }

    private void depthFirstSearch(int vertex) {
        // set visited
        marked[vertex] = true;

        // go through all adjacent
        Iterable<Integer> adjacent = unidirectedGraph.adjacent(vertex);
        for (Integer adj : adjacent) {
            // if not marked recursively go into vertex
            if (!marked[adj]) {
                depthFirstSearch(adj);
                edgeTo[adj] = vertex;
            }
        }
    }
}
