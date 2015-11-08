package week1;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import week1.graphs.Graph;
import week1.graphs.Graph1;
import week1.graphs.Graph2;
import week1.graphs.Path;

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
    public void pathTest() {
        Graph graph = new Graph1(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);

        Path path = new Path(graph, 0);
        Iterable<Integer> pathTo6 = path.pathTo(6);
        Assert.assertArrayEquals(Iterables.toArray(pathTo6, Integer.class), new Integer[]{1, 2, 5, 6});
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
}
