package week2.graphs;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 12:12
 */
public class DirectedEdge extends Edge {

    /**
     * Connection from v to w (directed) with weight.
     *
     * @param v             int
     * @param w             int
     * @param weight        double
     */
    public DirectedEdge(int v, int w, double weight) {
        super(v, w, weight);
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return v + " --> " + w + " [weight: " + weight + "]";
    }
}
