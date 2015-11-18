package week1;

import com.google.common.collect.Lists;
import org.junit.Test;
import week1.graphs.algorithms.BreadthFirstSearch;
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

    private DirectedGraph buildGraph() {
        /**
         A:  B
         B:  E F
         C:  B D
         D:  G
         E:  A F
         F:  C
         G:  F C
         H:  D G
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
}
