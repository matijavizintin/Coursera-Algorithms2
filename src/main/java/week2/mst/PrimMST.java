package week2.mst;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import week2.structures.graphs.EdgeWeightedUndirectedGraph;
import week2.structures.edges.UndirectedEdge;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 09:33
 */
public class PrimMST implements MST {
    private boolean[] marked;           // vertices in MST
    private Queue<UndirectedEdge> mst;            // MST
    private MinPQ<UndirectedEdge> pq;             // priority q for the MST

    public PrimMST(EdgeWeightedUndirectedGraph graph) {
        this(graph, 0);
    }

    public PrimMST(EdgeWeightedUndirectedGraph graph, int startNode) {
        pq = new MinPQ<>();
        mst = new Queue<>();
        marked = new boolean[graph.V()];
        visit(graph, startNode);

        // loop while the PQ is empty
        while (!pq.isEmpty()) {
            // pick minimum weighted edge
            UndirectedEdge edge = pq.delMin();

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

    private void visit(EdgeWeightedUndirectedGraph graph, int v) {
        // mark current as visited
        marked[v] = true;

        // go through all adjacent vertices and add them into a PQ if not both ends marked
        for (UndirectedEdge edge : graph.adjacent(v)) {
            if (!marked[edge.other(v)]) pq.insert(edge);
        }
    }

    @Override
    public Iterable<UndirectedEdge> edges() {
        return mst;
    }
}
