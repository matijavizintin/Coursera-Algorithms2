package week1;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import week1.graphs.unidirected.Path;
import week1.graphs.unidirected.UndirectedGraph;
import week1.graphs.unidirected.UndirectedGraph1;
import week1.graphs.unidirected.UndirectedGraph2;
import week1.graphs.unidirected.algorithms.BreadthFirstSearch;
import week1.graphs.unidirected.algorithms.ConnectedComponents;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:42
 */
public class UndirectedGraphTest {
    @Test
    public void simpleGraphTest() {
        UndirectedGraph undirectedGraph = buildSimpleGraph(UndirectedGraph1.class);

        String string = undirectedGraph.toString();
        System.out.println(string);
    }

    @Test
    public void simpleGraphTest1() {
        UndirectedGraph undirectedGraph = buildSimpleGraph(UndirectedGraph2.class);

        String string = undirectedGraph.toString();
        System.out.println(string);
    }

    @Test
    public void depthFirstTest() {
        UndirectedGraph undirectedGraph = buildGraph();

        Path path = new Path(undirectedGraph, 0);
        Iterable<Integer> pathTo6 = path.pathTo(6);
        Assert.assertArrayEquals(Iterables.toArray(pathTo6, Integer.class), new Integer[]{1, 2, 5, 6});
    }

    @Test
    public void breathFirstTest() {
        UndirectedGraph undirectedGraph = buildGraph();

        BreadthFirstSearch bfs = new BreadthFirstSearch(undirectedGraph, 0);
        Assert.assertArrayEquals(bfs.distTo, new int[]{0, 1, 2, 1, 1, 1, 2});
    }

    @Test
    public void connectedComponentsTest() {
        UndirectedGraph undirectedGraph = buildGraphForConnectedComponents();

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

    private UndirectedGraph buildSimpleGraph(Class clazz) {
        UndirectedGraph undirectedGraph;

        try {
            undirectedGraph = (UndirectedGraph)clazz.getConstructor(int.class).newInstance(10);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

        undirectedGraph.addEdge(3, 5);
        undirectedGraph.addEdge(1, 3);
        undirectedGraph.addEdge(1, 4);
        undirectedGraph.addEdge(4, 5);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 4);

        return undirectedGraph;
    }

    /**
     * 0 - 1 - 2 - 6 - 5
     *   - 3
     *   - 4
     *   - 5 - 6
     *       - 2
     *
     * @return      UndirectedGraph
     */
    private UndirectedGraph buildGraph() {
        UndirectedGraph undirectedGraph = new UndirectedGraph1(7);

        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(0, 3);
        undirectedGraph.addEdge(0, 4);
        undirectedGraph.addEdge(0, 5);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 5);
        undirectedGraph.addEdge(2, 6);
        undirectedGraph.addEdge(5, 6);

        return undirectedGraph;
    }

    public UndirectedGraph buildGraphForConnectedComponents() {
        UndirectedGraph undirectedGraph = new UndirectedGraph1(13);

        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(0, 2);
        undirectedGraph.addEdge(0, 6);
        undirectedGraph.addEdge(0, 5);
        undirectedGraph.addEdge(5, 3);
        undirectedGraph.addEdge(5, 4);
        undirectedGraph.addEdge(3, 4);
        undirectedGraph.addEdge(6, 4);

        undirectedGraph.addEdge(7, 8);

        undirectedGraph.addEdge(9, 10);
        undirectedGraph.addEdge(9, 11);
        undirectedGraph.addEdge(9, 12);
        undirectedGraph.addEdge(11, 12);
        return undirectedGraph;
    }
}
