package week1;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;
import week1.graphs.Graph;
import week1.graphs.algorithms.MultiSourceBFS;
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
        Graph graph = GraphBuilder.buildGraph(DirectGraphImpl.class);

        MultiSourceBFS mbfs = new MultiSourceBFS(graph, ImmutableList.of(0, 1, 2));

        // assert all marked
        Assert.assertArrayEquals(mbfs.marked, new boolean[] {true, true, true, true, true, true, true});

        // assert all paths 1
        Assert.assertArrayEquals(mbfs.distTo, new int[]{0, 0, 0, 1, 1, 1, 1});

        // assert edges
        Assert.assertArrayEquals(mbfs.edgeTo, new int[]{0, 1, 2, 0, 0, 0, 2});
    }

}
