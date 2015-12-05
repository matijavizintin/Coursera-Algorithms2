package week2.graphs;

/**
 * Created by Matija Vižintin
 * Date: 30. 11. 2015
 * Time: 21:01
 */
public class EdgeWightedDirectedGraph extends EdgeWightedGraph<DirectedEdge> {

    public EdgeWightedDirectedGraph(int vertices) {
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
}
