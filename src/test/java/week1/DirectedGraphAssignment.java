package week1;

import com.google.common.collect.Lists;
import org.junit.Test;
import week1.graphs.algorithms.BreadthFirstSearch;
import week1.graphs.algorithms.directed.DepthFirstOrder;
import week1.graphs.algorithms.directed.StronglyConnected;
import week1.graphs.directed.DirectGraphImpl;
import week1.graphs.directed.DirectedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matija Vižintin
 * Date: 18. 11. 2015
 * Time: 21:48
 */
public class DirectedGraphAssignment {

    @Test
    public void test1() {
        DirectedGraph g = buildGraph();

        BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
        for (int i : bfs.deQueueOrder) {
            System.out.print(UndirectedGraphAssignment.nodesMap.get(i) + " ");
        }
    }

    @Test
    public void test2() {
        DirectedGraph g = buildGraph2();

        DepthFirstOrder dfo = new DepthFirstOrder(g);
        for (Integer i : dfo.reversePost()) {
            System.out.print(UndirectedGraphAssignment.nodesMap.get(i) + " ");
        }
    }

    @Test
    public void test3() {
        DirectedGraph g = buildGraph3();

        StronglyConnected sc = new StronglyConnected(g, Lists.newArrayList(3, 8, 7, 9, 4, 0, 6, 1, 2, 5));
        for (int i : sc.scc) {
            System.out.print(i + " ");
        }
    }

    private DirectedGraph buildGraph() {
        /**
        0 A:  B
        1 B:  E F
        2 C:  B D
        3 D:  G
        4 E:  A F
        5 F:  C
        6 G:  F C
        7 H:  D G
         */

        List<String>[] adj = new ArrayList[8];

        adj[0] = Lists.<String>newArrayList("B");     // A
        adj[1] = Lists.<String>newArrayList("E", "F");     // B
        adj[2] = Lists.<String>newArrayList("B", "D");     // C
        adj[3] = Lists.<String>newArrayList("G");     // D
        adj[4] = Lists.<String>newArrayList("A", "F");     // E
        adj[5] = Lists.<String>newArrayList("C");     // F
        adj[6] = Lists.<String>newArrayList("F", "C");     // G
        adj[7] = Lists.<String>newArrayList("D", "G");     // H

        DirectGraphImpl graph = new DirectGraphImpl(8);
        graph.injectAdj(UndirectedGraphAssignment.convert(adj));

        return graph;
    }

    private DirectedGraph buildGraph2() {
        /**
         A:
         B:  C A F
         C:  D
         D:  H
         E:  F A B
         F:  C
         G:  F H C D
         H:
         */

        List<String>[] adj = new ArrayList[8];

        adj[0] = Lists.<String>newArrayList();     // A
        adj[1] = Lists.<String>newArrayList("C", "A", "F");     // B
        adj[2] = Lists.<String>newArrayList("D");     // C
        adj[3] = Lists.<String>newArrayList("H");     // D
        adj[4] = Lists.<String>newArrayList("F", "A", "B");     // E
        adj[5] = Lists.<String>newArrayList("C");     // F
        adj[6] = Lists.<String>newArrayList("F", "H", "C", "D");     // G
        adj[7] = Lists.<String>newArrayList();     // H

        DirectGraphImpl graph = new DirectGraphImpl(8);
        graph.injectAdj(UndirectedGraphAssignment.convert(adj));

        return graph;
    }

    private DirectedGraph buildGraph3() {
        /**
         A:  B F
         B:  G H
         C:  H D B
         D:  E H
         E:  J
         F:  G
         G:  H A
         H:  I
         I:  D E
         J:  I
         */

        List<String>[] adj = new ArrayList[10];

        adj[0] = Lists.<String>newArrayList("B", "F");     // A
        adj[1] = Lists.<String>newArrayList("G", "H");     // B
        adj[2] = Lists.<String>newArrayList("H", "D", "B");     // C
        adj[3] = Lists.<String>newArrayList("E", "H");     // D
        adj[4] = Lists.<String>newArrayList("J");     // E
        adj[5] = Lists.<String>newArrayList("G");     // F
        adj[6] = Lists.<String>newArrayList("H", "A");     // G
        adj[7] = Lists.<String>newArrayList("I");     // H
        adj[8] = Lists.<String>newArrayList("D", "E");     // I
        adj[9] = Lists.<String>newArrayList("I");     // J

        DirectGraphImpl graph = new DirectGraphImpl(10);
        graph.injectAdj(UndirectedGraphAssignment.convert(adj));

        return graph;
    }
}
