package week6;

import week1.graphs.Graph;

public class HamiltonPath {

    private boolean[] marked;
    private int count = 0;

    public HamiltonPath(Graph<Integer> g) {
        marked = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            dfs(g, i, 1);
        }
    }

    private void dfs(Graph<Integer> g, int v, int depth) {
        marked[v] = true;
        if (depth == g.V()) count++;

        for (int w : g.adjacent(v)) {
            if (!marked[w]) dfs(g, w, depth + 1);
        }

        marked[v] = false;
    }

    public int count() {
        return count;
    }
}
