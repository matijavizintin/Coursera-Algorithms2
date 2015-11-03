package week1.graphs;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:30
 */
public interface GraphInterface {
    // add an edge from v to w
    public void addEdge(int v, int w);

    // vertices adjacent to v
    public Iterable<Integer> adjacent(int v);

    // number of vertices
    public int vertices();

    // number of edges
    public int edges();
}
