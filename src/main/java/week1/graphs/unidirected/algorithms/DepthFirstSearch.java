package week1.graphs.unidirected.algorithms;

import week1.graphs.unidirected.UndirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 08. 11. 2015
 * Time: 19:35
 */
public class DepthFirstSearch {
    private UndirectedGraph undirectedGraph;

    public boolean[] marked;        // getters for arrays are so annoying
    public int[] edgeTo;

    public DepthFirstSearch(UndirectedGraph undirectedGraph, int source) {
        this.undirectedGraph = undirectedGraph;

        // init structures
        marked = new boolean[undirectedGraph.vertices()];
        edgeTo = new int[undirectedGraph.vertices()];

        depthFirstSearch(source);
    }

    private void depthFirstSearch(int vertex) {
        // set visited
        marked[vertex] = true;

        // go through all adjacent
        Iterable<Integer> adjacent = undirectedGraph.adjacent(vertex);
        for (Integer adj : adjacent) {
            // if not marked recursively go into vertex
            if (!marked[adj]) {
                depthFirstSearch(adj);
                edgeTo[adj] = vertex;
            }
        }
    }
}
