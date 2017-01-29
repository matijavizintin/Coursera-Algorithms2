package week3.maxflow;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import week3.graphs.FlowEdge;
import week3.graphs.FlowNetwork;

/**
 * Created by Matija Vižintin
 * Date: 13. 12. 2015
 * Time: 18:52
 */
public class FordFulkerson {
    public Stack<Integer> debug = new Stack<>();
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;

    public FordFulkerson(FlowNetwork flowNetwork, int s, int t) {
        // compute max flow
        value = 0.;
        while (hasAugmentingPath(flowNetwork, s, t)) {
            // find bottle-neck
            double bottleNeck = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottleNeck = Math.min(bottleNeck, edgeTo[v].residualCapacityTo(v));
                debug.push(v);
            }
            debug.push(s);

            // increment flow to all edges
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottleNeck);
            }

            // increment max flow
            value += bottleNeck;
        }
    }

    private boolean hasAugmentingPath(FlowNetwork flowNetwork, int s, int t) {
        // init
        marked = new boolean[flowNetwork.V()];
        edgeTo = new FlowEdge[flowNetwork.V()];

        // set up first node
        Queue<Integer> q = new Queue<>();
        q.enqueue(s);
        marked[s] = true;

        // loop until the q is empty (this is basically BFS)
        while (!q.isEmpty()) {
            int v = q.dequeue();

            // go through adjacent edges
            for (FlowEdge edge : flowNetwork.adjacent(v)) {
                int w = edge.other(v);

                // check if there is a path from s to w in the residual network
                if (edge.residualCapacityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = edge;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }

        // if t is reachable from residual network
        return marked[t];
    }

    /**
     * value == capacity of the min flow
     *
     * @return max-flow
     */
    public double value() {
        return value;
    }

    /**
     * Min cut is computed in the last loop where there is no augmenting path. All vertices that were marked by
     * hasAugmentingPath (BFS that stops when edges are full) are in min-cut. All edges from the min-cut are always
     * full and all edges to the min-cut are always empty. The sum of outgoing (incoming are empty) edges == max-flow
     *
     * @param v int
     * @return is v in min-cut
     */
    public boolean inCut(int v) {
        return marked[v];
    }
}
