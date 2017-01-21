package week2.structures.edges;

/**
 * Created by Matija Vižintin
 * Date: 30. 11. 2015
 * Time: 20:51
 */
public class UndirectedEdge extends Edge {
    /**
     * Connection from v to w (undirected) with weight.
     *
     * @param v             int
     * @param w             int
     * @param weight        double
     */
    public UndirectedEdge(int v, int w, double weight) {
        super(v, w, weight);
    }

    // picks one of the end
    public int either() {
        return v;
    }

    // returns the other end
    public int other(int v) {
        return v == this.v ? w : this.v;
    }

    // returns the other end
    public int other() {
        return w;
    }

    public boolean isAny(int v) {
        return this.v == v || this.w == v;
    }

    @Override
    public String toString() {
        return v + " <--> " + w + " [weight: " + weight + "]";
    }
}
