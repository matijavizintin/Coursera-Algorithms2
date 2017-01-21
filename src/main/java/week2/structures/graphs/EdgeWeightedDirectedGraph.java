package week2.structures.graphs;

import week1.graphs.directed.DirectedGraph;
import week2.structures.edges.DirectedEdge;

/**
 * Created by Matija Vižintin
 * Date: 30. 11. 2015
 * Time: 21:01
 */
public class EdgeWeightedDirectedGraph extends EdgeWeightedGraph<DirectedEdge> implements DirectedGraph<DirectedEdge> {

    public EdgeWeightedDirectedGraph(int vertices) {
        super(vertices);
    }

    // helper method that creates the edge object
    public void addEdge(int v, int w, double weight) {
        addEdge(new DirectedEdge(v, w, weight));
    }

    // inserts a directed edge into the graph
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        edges++;
    }

    @Override
    public DirectedGraph<DirectedEdge> reverse() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addEdge(int v, int w) {
        throw new UnsupportedOperationException();
    }
}
