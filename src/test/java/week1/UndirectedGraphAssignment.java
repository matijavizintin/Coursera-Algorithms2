package week1;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import org.junit.Test;
import week1.graphs.algorithms.BreadthFirstSearch;
import week1.graphs.algorithms.ConnectedComponents;
import week1.graphs.algorithms.DepthFirstSearch;
import week1.graphs.unidirected.UndirectedGraph;
import week1.graphs.unidirected.UndirectedGraphImpl2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matija Vižintin
 * Date: 15. 11. 2015
 * Time: 16:44
 */
public class UndirectedGraphAssignment {
    public static final BiMap<Integer, String> nodesMap = HashBiMap.create();

    static {
        nodesMap.put(0, "A");
        nodesMap.put(1, "B");
        nodesMap.put(2, "C");
        nodesMap.put(3, "D");
        nodesMap.put(4, "E");
        nodesMap.put(5, "F");
        nodesMap.put(6, "G");
        nodesMap.put(7, "H");
        nodesMap.put(8, "I");
        nodesMap.put(9, "J");
    }

    @Test
    public void test1() {
        UndirectedGraph g = buildGraph();

        DepthFirstSearch dfs = new DepthFirstSearch(g, 0);
        for (int i : dfs.preOrder) {
            System.out.print(nodesMap.get(i) + " ");
        }

    }

    @Test
    public void test2() {
        UndirectedGraph g = buildGraph2();

        BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
        for (int i : bfs.deQueueOrder) {
            System.out.print(nodesMap.get(i) + " ");
        }
    }

    @Test
    public void test3() {
        UndirectedGraph g = buildGraph3();

        ConnectedComponents cc = new ConnectedComponents(g);
        for (Integer integer : cc.cc) {
            System.out.print(integer + " ");
        }
    }

    private UndirectedGraph buildGraph() {
        /**
         * A:  E B F
         B:  A C G
         C:  G B
         D:  G
         E:  A
         F:  A G
         G:  C H F B D
         H:  G
         */

        List<String>[] adj = new ArrayList[8];

        adj[0] = Lists.<String>newArrayList("E", "B", "F");     // A
        adj[1] = Lists.<String>newArrayList("A", "C", "G");     // B
        adj[2] = Lists.<String>newArrayList("G", "B");     // C
        adj[3] = Lists.<String>newArrayList("G");     // D
        adj[4] = Lists.<String>newArrayList("A");     // E
        adj[5] = Lists.<String>newArrayList("A", "G");     // F
        adj[6] = Lists.<String>newArrayList("C", "H", "F", "B", "D");     // G
        adj[7] = Lists.<String>newArrayList("G");     // H

        UndirectedGraphImpl2 graph = new UndirectedGraphImpl2(8);
        graph.injectAdj(convert(adj));

        return graph;
    }

    private UndirectedGraph buildGraph2() {
        /**
         *
         A:  E
         B:  E F
         C:  F D
         D:  H G C
         E:  B A F
         F:  C G E B
         G:  H F D
         H:  G D
         */

        List<String>[] adj = new ArrayList[8];

        adj[0] = Lists.<String>newArrayList("E");     // A
        adj[1] = Lists.<String>newArrayList("E", "F");     // B
        adj[2] = Lists.<String>newArrayList("F", "D");     // C
        adj[3] = Lists.<String>newArrayList("H", "G", "C");     // D
        adj[4] = Lists.<String>newArrayList("B", "A", "F");     // E
        adj[5] = Lists.<String>newArrayList("C", "G", "E", "B");     // F
        adj[6] = Lists.<String>newArrayList("H", "F", "D");     // G
        adj[7] = Lists.<String>newArrayList("G", "D");     // H

        UndirectedGraphImpl2 graph = new UndirectedGraphImpl2(8);
        graph.injectAdj(convert(adj));

        return graph;
    }

    private UndirectedGraph buildGraph3() {
        /**
         *
         A:  F B
         B:  F C G A
         C:  G B
         D:  H I
         E:  J
         F:  A B G
         G:  C B F
         H:  I D
         I:  H D
         J:  E
         */

        List<String>[] adj = new ArrayList[10];

        adj[0] = Lists.<String>newArrayList("F", "B");     // A
        adj[1] = Lists.<String>newArrayList("F", "C", "G", "A");     // B
        adj[2] = Lists.<String>newArrayList("G", "B");     // C
        adj[3] = Lists.<String>newArrayList("H", "I");     // D
        adj[4] = Lists.<String>newArrayList("J");     // E
        adj[5] = Lists.<String>newArrayList("A", "B", "G");     // F
        adj[6] = Lists.<String>newArrayList("C", "B", "F");     // G
        adj[7] = Lists.<String>newArrayList("I", "D");     // H
        adj[8] = Lists.<String>newArrayList("H", "D");     // I
        adj[9] = Lists.<String>newArrayList("E");     // J

        UndirectedGraphImpl2 graph = new UndirectedGraphImpl2(10);
        graph.injectAdj(convert(adj));

        return graph;
    }

    public static LinkedList[] convert(List<String>[] adj) {
        LinkedList<Integer>[] converted = new LinkedList[adj.length];

        int counter = 0;
        for (List<String> strings : adj) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (String string : strings) {
                linkedList.add(nodesMap.inverse().get(string));
            }
            converted[counter++] = linkedList;
        }

        return converted;
    }
}
