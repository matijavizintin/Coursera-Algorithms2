package week1.graphs.unidirected;

import week1.graphs.Graph;
import week1.graphs.algorithms.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Matija Vižintin
 * Date: 08. 11. 2015
 * Time: 18:54
 */
public class Path {
    private int source;

    private DepthFirstSearch dfs;

    public Path(Graph undirectedGraph, int source) {
        this.source = source;

        // perform DFS on undirectedGraph
        dfs = new DepthFirstSearch(undirectedGraph, source);
    }

    // returns true if there is a path from s to v
    public boolean hasPathTo(int v) {
        return dfs.marked[v];
    }

    // path form s to v; null if it doesn't exist
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        int x = v;
        List<Integer> result = new ArrayList<>();
        while (x != source) {
            result.add(x);
            x = dfs.edgeTo[x];
        }
        Collections.reverse(result);
        return result;
    }
}
