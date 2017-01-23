package week3.graphs;

/**
 * Created by Matija Vižintin
 * Date: 13. 12. 2015
 * Time: 18:34
 */
public class FlowEdge {
    private final int v, w;
    private final double capacity;
    private double flow;

    public FlowEdge(int v, int w, double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public int other(int v) {
        return v == this.v ? this.w : this.v;
    }

    // edge capacity
    public double capacity() {
        return capacity;
    }

    // capacity used
    public double flow() {
        return flow;
    }

    // capacity left / flow
    public double residualCapacityTo(int v) {
        return v == this.w ? capacity - flow : flow;
    }

    // add flow / remove flow
    public void addResidualFlowTo(int v, double delta) {
        if (v == this.w) flow += delta;
        else flow -= delta;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(v).append(" --> ").append(w).append(" (").append(flow).append("/").append(capacity).append(")").toString();
    }
}
