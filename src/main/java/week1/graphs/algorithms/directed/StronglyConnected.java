package week1.graphs.algorithms.directed;

import week1.graphs.directed.DirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 13. 11. 2015
 * Time: 20:16
 */
public class StronglyConnected {
    private DirectedGraph directedGraph;

    public boolean[] marked;
    public int[] scc;

    public StronglyConnected(DirectedGraph directedGraph) {
        this.directedGraph = directedGraph;

        // init structures
        marked = new boolean[directedGraph.vertices()];
        scc = new int[directedGraph.vertices()];

        // process DFO on reverse graph
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(directedGraph.reverse());

        // go through all unmarked nodes
        int componentIndex = 0;
        for (Integer v : depthFirstOrder.reversePost()) {
            if (!marked[v]) {
                depthFirstSearch(v, componentIndex);
                componentIndex++;
            }
        }
    }

    public StronglyConnected(DirectedGraph directedGraph, Iterable<Integer> reversePostorder) {
        this.directedGraph = directedGraph;

        // init structures
        marked = new boolean[directedGraph.vertices()];
        scc = new int[directedGraph.vertices()];

        // go through all unmarked nodes
        int componentIndex = 0;
        for (Integer v : reversePostorder) {
            if (!marked[v]) {
                depthFirstSearch(v, componentIndex);
                componentIndex++;
            }
        }
    }

    private void depthFirstSearch(int vertex, int componentIndex) {
        // set visited
        marked[vertex] = true;

        // set scc
        scc[vertex] = componentIndex;

        // go through all adjacent
        for (Integer adj : directedGraph.adjacent(vertex)) {
            // if not marked recursively go into vertex
            if (!marked[adj]) {
                depthFirstSearch(adj, componentIndex);
            }
        }
    }

    public boolean stroglyConnected(int v, int w) {
        return scc[v] == scc[w];
    }
}
