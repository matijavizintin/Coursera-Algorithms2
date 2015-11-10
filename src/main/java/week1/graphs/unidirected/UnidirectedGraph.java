package week1.graphs.unidirected;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:30
 */
public interface UnidirectedGraph {

    // add an edge from v to w
    void addEdge(int v, int w);

    // vertices adjacent to v
    Iterable<Integer> adjacent(int v);

    // number of vertices
    int vertices();

    // number of edges
    int edges();
}
