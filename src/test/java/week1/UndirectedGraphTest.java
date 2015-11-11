package week1;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import week1.graphs.Graph;
import week1.graphs.algorithms.BreadthFirstSearch;
import week1.graphs.algorithms.ConnectedComponents;
import week1.graphs.unidirected.Path;
import week1.graphs.unidirected.UndirectedGraphImpl1;
import week1.graphs.unidirected.UndirectedGraphImpl2;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:42
 */
public class UndirectedGraphTest {

    @Test
    public void simpleGraphTest() {
        Graph graph = GraphBuilder.buildSimpleGraph(UndirectedGraphImpl1.class);

        String string = graph.toString();
        System.out.println(string);
    }

    @Test
    public void simpleGraphTest1() {
        Graph undirectedGraph = GraphBuilder.buildSimpleGraph(UndirectedGraphImpl2.class);

        String string = undirectedGraph.toString();
        System.out.println(string);
    }

    @Test
    public void depthFirstTest() {
        Graph undirectedGraph = GraphBuilder.buildGraph(UndirectedGraphImpl1.class);

        Path path = new Path(undirectedGraph, 0);
        Iterable<Integer> pathTo6 = path.pathTo(6);
        Assert.assertArrayEquals(Iterables.toArray(pathTo6, Integer.class), new Integer[]{1, 2, 5, 6});
    }

    @Test
    public void breathFirstTest() {
        Graph undirectedGraph = GraphBuilder.buildGraph(UndirectedGraphImpl1.class);

        BreadthFirstSearch bfs = new BreadthFirstSearch(undirectedGraph, 0);
        Assert.assertArrayEquals(bfs.distTo, new int[]{0, 1, 2, 1, 1, 1, 2});
    }

    @Test
    public void connectedComponentsTest() {
        Graph undirectedGraph = GraphBuilder.buildGraphForConnectedComponents(UndirectedGraphImpl1.class);

        ConnectedComponents cc = new ConnectedComponents(undirectedGraph);

        Assert.assertTrue(cc.connected(0, 1));
        Assert.assertTrue(cc.connected(0, 2));
        Assert.assertTrue(cc.connected(0, 3));
        Assert.assertTrue(cc.connected(0, 4));
        Assert.assertTrue(cc.connected(7, 8));
        Assert.assertTrue(cc.connected(11, 12));
        Assert.assertTrue(cc.connected(9, 11));

        Assert.assertFalse(cc.connected(0, 7));
        Assert.assertFalse(cc.connected(7, 9));
        Assert.assertFalse(cc.connected(2, 11));

        Assert.assertTrue(cc.id(0) == 0);
        Assert.assertTrue(cc.id(1) == 0);
        Assert.assertTrue(cc.id(2) == 0);
        Assert.assertTrue(cc.id(3) == 0);
        Assert.assertTrue(cc.id(4) == 0);
        Assert.assertTrue(cc.id(7) == 1);
        Assert.assertTrue(cc.id(8) == 1);
        Assert.assertTrue(cc.id(9) == 2);
        Assert.assertTrue(cc.id(11) == 2);
        Assert.assertTrue(cc.id(12) == 2);
    }
}
