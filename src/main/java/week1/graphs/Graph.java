package week1.graphs;

/**
 * Created by Matija Vižintin
 * Date: 11. 11. 2015
 * Time: 19:17
 */
public interface Graph {

    // add an edge from v to w
    void addEdge(int v, int w);

    // vertices adjacent to v
    Iterable<Integer> adjacent(int v);

    // number of vertices
    int vertices();

    // number of edges
    int edges();
}
