package week2.shortestpaths;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import week2.graphs.DirectedEdge;
import week2.graphs.EdgeWeightedDirectedGraph;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 12:31
 */
public class ShortestPaths {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private int start;

    public ShortestPaths(EdgeWeightedDirectedGraph graph, int start) {
        this.start = start;
        edgeTo = new DirectedEdge[graph.V()];
        distTo = new double[graph.V()];
        boolean[] marked = new boolean[graph.V()];

        // init distTo
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0;  // update start pos

        // simple algorithm that goes through all vertices and computes distance to adjacent
        Queue<Integer> verticesQueue = new Queue<>();
        verticesQueue.enqueue(start);
        while (!verticesQueue.isEmpty()) {      // loop until we visited all connected vertices
            // enqueue vertex and set as marked
            int vertex = verticesQueue.dequeue();
            marked[vertex] = true;

            // go through all adjacent - if not already in q or processed (marked) then add it to q
            for (DirectedEdge directedEdge : graph.adj(vertex)) {
                if (!marked[directedEdge.to()]) verticesQueue.enqueue(directedEdge.to());
                relax(directedEdge);
            }
        }
    }

    private void relax(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();

        // if dist to w is gt dist to v + edge's weight then relax (shortest path found) the edge
        if (distTo[w] > distTo[v] + edge.weight()) {
            distTo[w] = distTo[v] + edge.weight();      // update dist
            edgeTo[w] = edge;                           // update edge
        }
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
}
