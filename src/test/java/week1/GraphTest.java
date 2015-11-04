package week1;

import org.junit.Test;
import week1.graphs.Graph;
import week1.graphs.Graph2;
import week1.graphs.GraphInterface;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:42
 */
public class GraphTest {
    @Test
    public void simpleGraphTest() {
        GraphInterface graph = buildSimpleGraph(Graph.class);

        String string = graph.toString();
        System.out.println(string);
    }

    @Test
    public void simpleGraphTest1() {
        GraphInterface graph = buildSimpleGraph(Graph2.class);

        String string = graph.toString();
        System.out.println(string);
    }

    private GraphInterface buildSimpleGraph(Class clazz) {
        GraphInterface graph;

        try {
            graph = (GraphInterface)clazz.getConstructor(int.class).newInstance(10);
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
