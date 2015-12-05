package week2.mst;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;
import week2.graphs.EdgeWightedUndirectedGraph;
import week2.graphs.UndirectedEdge;

/**
 * Created by Matija Vižintin
 * Date: 04. 12. 2015
 * Time: 20:06
 */
public class KruskalMST implements MST {
    private Queue<UndirectedEdge> mst = new Queue<>();

    /**
     * Build a minimum spanning tree using kruskal's algorithm.
     *
     * @param graph     EdgeWightedUndirectedGraph
     */
    public KruskalMST(EdgeWightedUndirectedGraph graph) {
        // put all edges into a PQ sorted by weight - lowest first
        MinPQ<UndirectedEdge> pq = new MinPQ<>();
        for (UndirectedEdge edge : graph.edges()) {
            pq.insert(edge);
        }

        // create union find structure so we can quickly detect potential loops with adding new edges
        UF unionFind = new UF(graph.V());
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            // pick min edge from q
            UndirectedEdge edge = pq.delMin();
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
     * @return          Iterable<UndirectedEdge>
     */
    public Iterable<UndirectedEdge> edges() {
        return mst;
    }
}
