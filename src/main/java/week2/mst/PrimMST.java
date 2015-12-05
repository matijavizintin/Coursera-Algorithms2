package week2.mst;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import week2.mst.graphs.Edge;
import week2.mst.graphs.EdgeWightedGraph;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 09:33
 */
public class PrimMST implements MST {
    private boolean[] marked;           // vertices in MST
    private Queue<Edge> mst;            // MST
    private MinPQ<Edge> pq;             // priority q for the MST

    public PrimMST(EdgeWightedGraph graph) {
        pq = new MinPQ<>();
        mst = new Queue<>();
        marked = new boolean[graph.V()];
        visit(graph, 0);

        // loop while the PQ is empty
        while (!pq.isEmpty()) {
            // pick minimum weighted edge
            Edge edge = pq.delMin();

            // check if both ends already in tree
            int v = edge.either();
            int w = edge.other(v);
            if (marked[v] && marked[w]) continue;

            // put in q and visit if not marked (as already visited)
            mst.enqueue(edge);
            if (!marked[v]) visit(graph, v);
            if (!marked[w]) visit(graph, w);
        }
    }

    private void visit(EdgeWightedGraph graph, int v) {
        // mark current as visited
        marked[v] = true;

        // go through all adjacent vertices and add them into a PQ if not both ends marked
        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.other(v)]) pq.insert(edge);
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }
}
