package week2.structures.edges;

/**
 * Created by Matija Vižintin
 * Date: 30. 11. 2015
 * Time: 20:51
 */
public abstract class Edge implements Comparable<Edge> {
    protected int v, w;
    protected double weight;

    /**
     * Connection from v to w with weight.
     *
     * @param v             int
     * @param w             int
     * @param weight        double
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Edge edge = (Edge)o;

        if (v != edge.v) {
            return false;
        }
        if (w != edge.w) {
            return false;
        }
        return Double.compare(edge.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = v;
        result = 31 * result + w;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        return result;
    }

    public double weight() {
        return weight;
    }
}
