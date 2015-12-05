package week2.shortestpaths;

import edu.princeton.cs.algs4.Stack;
import week2.graphs.DirectedEdge;
import week2.graphs.EdgeWeightedDirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 12:31
 */
public abstract class ShortestPaths {
    protected DirectedEdge[] edgeTo;
    protected double[] distTo;
    protected int start;
    protected EdgeWeightedDirectedGraph graph;

    public ShortestPaths(EdgeWeightedDirectedGraph graph, int start) {
        this.graph = graph;
        this.start = start;

        // init
        initStructures();

        // execute algorithm
        findShortestPaths();
    }

    protected void initStructures() {
        // init distTo and edgeTo
        edgeTo = new DirectedEdge[graph.V()];
        distTo = new double[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0;  // update start pos
    }

    protected abstract void findShortestPaths();

    protected boolean relax(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();

        // if dist to w is gt dist to v + edge's weight then relax (shortest path found) the edge
        if (distTo[w] > distTo[v] + edge.weight()) {
            distTo[w] = distTo[v] + edge.weight();      // update dist
            edgeTo[w] = edge;                           // update edge

            // edge was relaxed
            return true;
        }
        return false;       // nothing was done
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> stack = new Stack<>();

        // go through the edges from v until there are no more edges (we came back to start)
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) stack.push(edge);
        return stack;
    }

    public boolean hasPathTo(int v) {
        return start == v || pathTo(v).iterator().hasNext();
    }

    public int V() {
        return graph.V();
    }
}
