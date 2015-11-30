package week2;

import org.junit.Test;
import week2.mst.graphs.EdgeWightedGraph;

/**
 * Created by Matija Vižintin
 * Date: 29. 11. 2015
 * Time: 16:41
 */
public class MSTTest {

    @Test
    public void test1() {
        // build graph
        EdgeWightedGraph wg = new EdgeWightedGraph(8);
        wg.addEdge(0, 7, 0.16);
        wg.addEdge(2, 3, 0.17);
        wg.addEdge(1, 7, 0.19);
        wg.addEdge(0, 2, 0.26);
        wg.addEdge(1, 3, 0.29);
        wg.addEdge(1, 5, 0.32);
        wg.addEdge(2, 7, 0.34);
        wg.addEdge(4, 5, 0.35);
        wg.addEdge(1, 2, 0.36);
        wg.addEdge(4, 7, 0.37);
        wg.addEdge(0, 4, 0.38);
        wg.addEdge(6, 2, 0.40);
        wg.addEdge(3, 6, 0.52);
        wg.addEdge(6, 0, 0.58);
        wg.addEdge(6, 4, 0.93);
    }
}
