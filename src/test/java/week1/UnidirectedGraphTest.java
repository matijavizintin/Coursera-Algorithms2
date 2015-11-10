package week1;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import week1.graphs.unidirected.Path;
import week1.graphs.unidirected.UnidirectedGraph;
import week1.graphs.unidirected.UnidirectedGraph1;
import week1.graphs.unidirected.UnidirectedGraph2;
import week1.graphs.unidirected.algorithms.BreadthFirstSearch;
import week1.graphs.unidirected.algorithms.ConnectedComponents;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:42
 */
public class UnidirectedGraphTest {
    @Test
    public void simpleGraphTest() {
        UnidirectedGraph unidirectedGraph = buildSimpleGraph(UnidirectedGraph1.class);

        String string = unidirectedGraph.toString();
        System.out.println(string);
    }

    @Test
    public void simpleGraphTest1() {
        UnidirectedGraph unidirectedGraph = buildSimpleGraph(UnidirectedGraph2.class);

        String string = unidirectedGraph.toString();
        System.out.println(string);
    }

    @Test
    public void depthFirstTest() {
        UnidirectedGraph unidirectedGraph = buildGraph();

        Path path = new Path(unidirectedGraph, 0);
        Iterable<Integer> pathTo6 = path.pathTo(6);
        Assert.assertArrayEquals(Iterables.toArray(pathTo6, Integer.class), new Integer[]{1, 2, 5, 6});
    }

    @Test
    public void breathFirstTest() {
        UnidirectedGraph unidirectedGraph = buildGraph();

        BreadthFirstSearch bfs = new BreadthFirstSearch(unidirectedGraph, 0);
        Assert.assertArrayEquals(bfs.distTo, new int[]{0, 1, 2, 1, 1, 1, 2});
    }

    @Test
    public void connectedComponentsTest() {
        UnidirectedGraph unidirectedGraph = buildGraphForConnectedComponents();

        ConnectedComponents cc = new ConnectedComponents(unidirectedGraph);

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

    private UnidirectedGraph buildSimpleGraph(Class clazz) {
        UnidirectedGraph unidirectedGraph;

        try {
            unidirectedGraph = (UnidirectedGraph)clazz.getConstructor(int.class).newInstance(10);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

        unidirectedGraph.addEdge(3, 5);
        unidirectedGraph.addEdge(1, 3);
        unidirectedGraph.addEdge(1, 4);
        unidirectedGraph.addEdge(4, 5);
        unidirectedGraph.addEdge(2, 3);
        unidirectedGraph.addEdge(1, 2);
        unidirectedGraph.addEdge(2, 4);

        return unidirectedGraph;
    }

    /**
     * 0 - 1 - 2 - 6 - 5
     *   - 3
     *   - 4
     *   - 5 - 6
     *       - 2
     *
     * @return      UnidirectedGraph
     */
    private UnidirectedGraph buildGraph() {
        UnidirectedGraph unidirectedGraph = new UnidirectedGraph1(7);

        unidirectedGraph.addEdge(0, 1);
        unidirectedGraph.addEdge(0, 3);
        unidirectedGraph.addEdge(0, 4);
        unidirectedGraph.addEdge(0, 5);
        unidirectedGraph.addEdge(1, 2);
        unidirectedGraph.addEdge(2, 5);
        unidirectedGraph.addEdge(2, 6);
        unidirectedGraph.addEdge(5, 6);

        return unidirectedGraph;
    }

    public UnidirectedGraph buildGraphForConnectedComponents() {
        UnidirectedGraph unidirectedGraph = new UnidirectedGraph1(13);

        unidirectedGraph.addEdge(0, 1);
        unidirectedGraph.addEdge(0, 2);
        unidirectedGraph.addEdge(0, 6);
        unidirectedGraph.addEdge(0, 5);
        unidirectedGraph.addEdge(5, 3);
        unidirectedGraph.addEdge(5, 4);
        unidirectedGraph.addEdge(3, 4);
        unidirectedGraph.addEdge(6, 4);

        unidirectedGraph.addEdge(7, 8);

        unidirectedGraph.addEdge(9, 10);
        unidirectedGraph.addEdge(9, 11);
        unidirectedGraph.addEdge(9, 12);
        unidirectedGraph.addEdge(11, 12);
        return unidirectedGraph;
    }
}
