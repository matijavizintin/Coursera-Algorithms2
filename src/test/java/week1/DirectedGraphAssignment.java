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

        /*
         * A = 0
         * B = 1
         * C = 2
         * D = 3
         * E = 4
         * F = 5
         * G = 6
         * H = 7
         * I = 8
         * J = 9
         */

                                                                        // D I J E A F B H C G
        StronglyConnected sc = new StronglyConnected(g, Lists.newArrayList(3, 8, 9, 4, 0, 5, 1, 7, 2, 6));
        for (int i : sc.scc) {
            System.out.print(i + " ");
        }
    }

    private DirectedGraph buildGraph() {
        /**
         A:  B E
         B:  C E
         C:  F G D
         D:  H
         E:  F
         F:  B
         G:  H F
         H:  C
         */

        List<String>[] adj = new ArrayList[8];

        adj[0] = Lists.<String>newArrayList("B", "E");     // A
        adj[1] = Lists.<String>newArrayList("C", "E");     // B
        adj[2] = Lists.<String>newArrayList("F", "G", "D");     // C
        adj[3] = Lists.<String>newArrayList("H");     // D
        adj[4] = Lists.<String>newArrayList("F");     // E
        adj[5] = Lists.<String>newArrayList("B");     // F
        adj[6] = Lists.<String>newArrayList("H", "F");     // G
        adj[7] = Lists.<String>newArrayList("C");     // H

        DirectGraphImpl graph = new DirectGraphImpl(8);
        graph.injectAdj(UndirectedGraphAssignment.convert(adj));

        return graph;
    }

    private DirectedGraph buildGraph2() {
        /**
         A:
         B:  C A F E G
         C:  D G
         D:  G
         E:  A F
         F:  G
         G:
         H:  G D
         */

        List<String>[] adj = new ArrayList[8];

        adj[0] = Lists.<String>newArrayList();     // A
        adj[1] = Lists.<String>newArrayList("C", "A", "F", "E", "G");     // B
        adj[2] = Lists.<String>newArrayList("D", "G");     // C
        adj[3] = Lists.<String>newArrayList("G");     // D
        adj[4] = Lists.<String>newArrayList("A", "F");     // E
        adj[5] = Lists.<String>newArrayList("G");     // F
        adj[6] = Lists.<String>newArrayList();     // G
        adj[7] = Lists.<String>newArrayList("G", "D");     // H

        DirectGraphImpl graph = new DirectGraphImpl(8);
        graph.injectAdj(UndirectedGraphAssignment.convert(adj));

        return graph;
    }

    private DirectedGraph buildGraph3() {
        /**
         A:  B
         B:  F
         C:  H D B
         D:  E
         E:  J
         F:  A G
         G:  B H
         H:  I B D
         I:  E D
         J:  I
         */

        List<String>[] adj = new ArrayList[10];

        adj[0] = Lists.<String>newArrayList("B");     // A
        adj[1] = Lists.<String>newArrayList("F");     // B
        adj[2] = Lists.<String>newArrayList("H", "D", "B");     // C
        adj[3] = Lists.<String>newArrayList("E");     // D
        adj[4] = Lists.<String>newArrayList("J");     // E
        adj[5] = Lists.<String>newArrayList("A", "G");     // F
        adj[6] = Lists.<String>newArrayList("B", "H");     // G
        adj[7] = Lists.<String>newArrayList("I", "B", "D");     // H
        adj[8] = Lists.<String>newArrayList("E", "D");     // I
        adj[9] = Lists.<String>newArrayList("I");     // J

        DirectGraphImpl graph = new DirectGraphImpl(10);
        graph.injectAdj(UndirectedGraphAssignment.convert(adj));

        return graph;
    }
}
