package week1;

import org.junit.Test;
import week1.graphs.Graph;
import week1.graphs.directed.DirectGraphImpl;

/**
 * Created by Matija Vižintin
 * Date: 10. 11. 2015
 * Time: 21:53
 */
public class DirectedGraphTest {

    @Test
    public void simpleTest() {
        Graph graph = GraphBuilder.buildGraph(DirectGraphImpl.class);

        String string = graph.toString();
        System.out.println(string);
    }

    @Test
    public void multiSourceBFSTest() {

    }

}
