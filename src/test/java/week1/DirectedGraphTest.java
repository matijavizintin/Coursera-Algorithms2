package week1;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import week1.graphs.Graph;
import week1.graphs.algorithms.MultiSourceBFS;
import week1.graphs.algorithms.directed.DepthFirstOrder;
import week1.graphs.algorithms.directed.StronglyConnected;
import week1.graphs.directed.DirectGraphImpl;
import week1.graphs.directed.DirectedGraph;

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
        Graph graph = GraphBuilder.buildGraph(DirectGraphImpl.class);

        MultiSourceBFS mbfs = new MultiSourceBFS(graph, ImmutableList.of(0, 1, 2));

        // assert all marked
        Assert.assertArrayEquals(mbfs.marked, new boolean[] {true, true, true, true, true, true, true});

        // assert all paths 1
        Assert.assertArrayEquals(mbfs.distTo, new int[]{0, 0, 0, 1, 1, 1, 1});

        // assert edges
        Assert.assertArrayEquals(mbfs.edgeTo, new int[]{0, 1, 2, 0, 0, 0, 2});
    }

    @Test
    public void depthFirstOrderTest() {
        DirectedGraph graph = GraphBuilder.buildGraphFirstOrder(DirectGraphImpl.class);

        DepthFirstOrder dfo = new DepthFirstOrder(graph);
        Assert.assertArrayEquals(new Integer[]{3, 6, 0, 5, 2, 1, 4}, Iterables.toArray(dfo.reversePost(), Integer.class));
    }

    @Test
    public void stronglyConnectedTest() {
        DirectedGraph graph = GraphBuilder.buildStroglyConnectedComponents(DirectGraphImpl.class);

        // first test reverse DFO
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph.reverse());
        Assert.assertArrayEquals(
                new Integer[]{1, 0, 2, 3, 4, 11, 9, 12, 10, 6, 8, 7, 5}, Iterables.toArray(depthFirstOrder.reversePost(), Integer.class));

        // test strongly connected result
        StronglyConnected stronglyConnected = new StronglyConnected(graph);
        Assert.assertArrayEquals(new int[]{1, 0, 1, 1, 1, 1, 3, 4, 3, 2, 2, 2, 2}, stronglyConnected.scc);
    }

}
