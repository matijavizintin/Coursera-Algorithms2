package week1;

import week1.graphs.Graph;
import week1.graphs.directed.DirectedGraph;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Matija Vižintin
 * Date: 11. 11. 2015
 * Time: 19:46
 */
public class GraphBuilder {
    public static Graph buildSimpleGraph(Class clazz) {
        Graph graph = instance(clazz, 6);

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
    public static Graph buildGraph(Class clazz) {
        Graph graph = instance(clazz, 7);

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

    public static Graph buildGraphForConnectedComponents(Class clazz) {
        Graph graph = instance(clazz, 13);

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

    public static DirectedGraph buildGraphFirstOrder(Class<? extends DirectedGraph> clazz) {
        DirectedGraph graph = instance(clazz, 7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(5, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(6, 4);
        graph.addEdge(6, 0);

        return graph;
    }

    public static DirectedGraph<Integer> buildStronglyConnectedComponents(Class<? extends DirectedGraph> clazz) {
        DirectedGraph<Integer> graph = instance(clazz, 13);

        graph.addEdge(4, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(6, 0);
        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(11, 12);
        graph.addEdge(12, 9);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(7, 9);
        graph.addEdge(10, 12);
        graph.addEdge(11, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 5);
        graph.addEdge(6, 8);
        graph.addEdge(8, 6);
        graph.addEdge(5, 4);
        graph.addEdge(0, 5);
        graph.addEdge(6, 4);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);

        return graph;
    }

    public static Graph buildGraphForHamilton(Class clazz) {
        Graph graph = instance(clazz, 8);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        graph.addEdge(7, 6);
        graph.addEdge(6, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 0);

        graph.addEdge(1, 7);
        graph.addEdge(7, 0);
        graph.addEdge(0, 5);
        graph.addEdge(5, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 3);

        return graph;
    }

    private static <T extends Graph> T instance(Class<T> clazz, int paramter) {
        try {
            return clazz.getConstructor(int.class).newInstance(paramter);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
