package week1.graphs.directed;

import week1.graphs.Graph;

/**
 * Created by Matija Vižintin
 * Date: 10. 11. 2015
 * Time: 21:12
 */
public interface DirectedGraph extends Graph {

    DirectedGraph reverse();
}
