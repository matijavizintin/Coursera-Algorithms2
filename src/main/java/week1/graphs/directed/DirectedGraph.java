package week1.graphs.directed;

/**
 * Created by Matija Vižintin
 * Date: 10. 11. 2015
 * Time: 21:12
 */
public interface DirectedGraph {

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    int vertices();

    int edges();

    DirectedGraph reverse();
}
