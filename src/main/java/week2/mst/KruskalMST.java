package week2.mst;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;
import week2.mst.graphs.Edge;
import week2.mst.graphs.EdgeWightedGraph;

/**
 * Created by Matija Vižintin
 * Date: 04. 12. 2015
 * Time: 20:06
 */
public class KruskalMST {
    private Queue<Edge> mst = new Queue<>();

    /**
     * Build a minimum spanning tree using kruskal's algorithm.
     *
     * @param graph     EdgeWightedGraph
     */
    public KruskalMST(EdgeWightedGraph graph) {
        // put all edges into a PQ sorted by weight - lowest first
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }

        // create union find structure so we can quickly detect potential loops with adding new edges
        UF unionFind = new UF(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            // pick min edge from q
            Edge edge = pq.delMin();
            int v = edge.either();
            int w = edge.other(v);

            // if not connected in union find it means it won't crate a loop in graph
            if (!unionFind.connected(v, w)) {
                unionFind.union(v, w);
                mst.enqueue(edge);      // put into MST
            }
        }
    }

    /**
     * Returns the minimum spanning tree.
     *
     * @return          Iterable<Edge>
     */
    public Iterable<Edge> edges() {
        return mst;
    }
}
