package week2.graphs;

/**
 * Created by Matija Vižintin
 * Date: 30. 11. 2015
 * Time: 21:01
 */
public class EdgeWightedUndirectedGraph extends EdgeWightedGraph<UndirectedEdge> {

    public EdgeWightedUndirectedGraph(int vertices) {
        super(vertices);
    }

    // helper method that creates the edge object
    public void addEdge(int v, int w, double weight) {
        addEdge(new UndirectedEdge(v, w, weight));
    }

    // inserts a undirected edge into the graph
    public void addEdge(UndirectedEdge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        edges++;
    }
}
