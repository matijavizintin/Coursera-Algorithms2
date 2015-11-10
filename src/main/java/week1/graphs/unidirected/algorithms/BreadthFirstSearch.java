package week1.graphs.unidirected.algorithms;

import week1.graphs.unidirected.UndirectedGraph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Matija Vižintin
 * Date: 08. 11. 2015
 * Time: 22:34
 */
public class BreadthFirstSearch {
    public boolean[] marked;
    public int[] edgeTo;
    public int[] distTo;

    public BreadthFirstSearch(UndirectedGraph undirectedGraph, int source) {
        marked = new boolean[undirectedGraph.vertices()];
        edgeTo = new int[undirectedGraph.vertices()];
        distTo = new int[undirectedGraph.vertices()];

        visit(undirectedGraph, source);
    }

    // remove all nodes from a undirectedGraph using BFS
    public void visit(UndirectedGraph undirectedGraph, int start) {

        // add first element to a queue
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        marked[start] = true;

        // while the queue is not empty
        while (!queue.isEmpty()) {
            // poll
            Integer vertex = queue.poll();

            // go through adjacent
            Iterable<Integer> adjacent = undirectedGraph.adjacent(vertex);
            for (Integer adj : adjacent) {

                // if not visited add to q
                if (!marked[adj]) {
                    queue.add(adj);
                    marked[adj] = true;
                    edgeTo[adj] = vertex;
                    distTo[adj] = distTo[vertex] + 1;
                }
            }
        }
    }
}
