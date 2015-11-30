package week2.mst.graphs;

/**
 * Created by Matija Vižintin
 * Date: 30. 11. 2015
 * Time: 21:22
 */
public class MST {
    private EdgeWightedGraph edgeWightedGraph;

    public MST(EdgeWightedGraph edgeWightedGraph) {
        this.edgeWightedGraph = edgeWightedGraph;
    }

    private Iterable<Edge> edges() {
        return edgeWightedGraph.edges();
    }

    private double weight() {
        return 0.;      // TODO:...
    }
}
