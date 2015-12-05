package week1.graphs.algorithms;

import week1.graphs.Graph;

/**
 * Created by Matija Vižintin
 * Date: 09. 11. 2015
 * Time: 20:57
 */
public class ConnectedComponents {
    private Graph<Integer> graph;

    public boolean[] marked;
    public int[] cc;

    public ConnectedComponents(Graph<Integer> graph) {
        this.graph = graph;

        // init structures
        marked = new boolean[graph.V()];
        cc = new int[graph.V()];

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
        for (Integer adj : graph.adjacent(vertex)) {
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
        return graph.V();
    }

    // id of set of vertices
    public int id(int v) {
        return cc[v];
    }
}
