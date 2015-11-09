package week1;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import week1.graphs.Graph;
import week1.graphs.Graph1;
import week1.graphs.Graph2;
import week1.graphs.Path;
import week1.graphs.algorithms.BreadthFirstSearch;
import week1.graphs.algorithms.ConnectedComponents;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:42
 */
public class GraphTest {
    @Test
    public void simpleGraphTest() {
        Graph graph = buildSimpleGraph(Graph1.class);

        String string = graph.toString();
        System.out.println(string);
    }

    @Test
    public void simpleGraphTest1() {
        Graph graph = buildSimpleGraph(Graph2.class);

        String string = graph.toString();
        System.out.println(string);
    }

    @Test
    public void depthFirstTest() {
        Graph graph = buildGraph();

        Path path = new Path(graph, 0);
        Iterable<Integer> pathTo6 = path.pathTo(6);
        Assert.assertArrayEquals(Iterables.toArray(pathTo6, Integer.class), new Integer[]{1, 2, 5, 6});
    }

    @Test
    public void breathFirstTest() {
        Graph graph = buildGraph();

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        Assert.assertArrayEquals(bfs.distTo, new int[]{0, 1, 2, 1, 1, 1, 2});
    }

    @Test
    public void connectedComponentsTest() {
        Graph graph = buildGraphForConnectedComponents();

        ConnectedComponents cc = new ConnectedComponents(graph);

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

    private Graph buildSimpleGraph(Class clazz) {
        Graph graph;

        try {
            graph = (Graph)clazz.getConstructor(int.class).newInstance(10);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

        graph.addEdge(3, 5);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);

        return graph;
    }

    /**
     * 0 - 1 - 2 - 6 - 5
     *   - 3
     *   - 4
     *   - 5 - 6
     *       - 2
     *
     * @return      Graph
     */
    private Graph buildGraph() {
        Graph graph = new Graph1(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);

        return graph;
    }

    public Graph buildGraphForConnectedComponents() {
        Graph graph = new Graph1(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(0, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(6, 4);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
        return graph;
    }
}
