package week1.graphs.unidirected.algorithms;

import week1.graphs.unidirected.UnidirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 09. 11. 2015
 * Time: 20:57
 */
public class ConnectedComponents {
    private UnidirectedGraph unidirectedGraph;

    public boolean[] marked;
    public int[] cc;

    public ConnectedComponents(UnidirectedGraph unidirectedGraph) {
        this.unidirectedGraph = unidirectedGraph;

        // init structures
        marked = new boolean[unidirectedGraph.vertices()];
        cc = new int[unidirectedGraph.vertices()];

        int index = 0;
        for (int i = 0; i < marked.length; i++) {
            // if not marked process DFS on this node
            if (!marked[i]) {
                depthFirstSearch(i, index);

                // increment group index
                index++;
            }
        }
    }

    private void depthFirstSearch(int vertex, int ccIndex) {
        // set visited and set group index
        marked[vertex] = true;
        cc[vertex] = ccIndex;

        // go through all adjacent
        for (Integer adj : unidirectedGraph.adjacent(vertex)) {
            // if not marked recursively go into vertex
            if (!marked[adj]) {
                depthFirstSearch(adj, ccIndex);
            }
        }
    }

    public boolean connected(int v, int w) {
        return cc[v] == cc[w];
    }

    public int count() {
        return unidirectedGraph.vertices();
    }

    // id of set of vertices
    public int id(int v) {
        return cc[v];
    }
}
