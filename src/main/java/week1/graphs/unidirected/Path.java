package week1.graphs.unidirected;

import week1.graphs.unidirected.algorithms.DepthFirstSearch;

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

    public Path(UnidirectedGraph unidirectedGraph, int source) {
        this.source = source;

        // perform DFS on unidirectedGraph
        dfs = new DepthFirstSearch(unidirectedGraph, source);
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
