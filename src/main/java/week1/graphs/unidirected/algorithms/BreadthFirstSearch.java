package week1.graphs.unidirected.algorithms;

import week1.graphs.unidirected.UnidirectedGraph;

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

    public BreadthFirstSearch(UnidirectedGraph unidirectedGraph, int source) {
        marked = new boolean[unidirectedGraph.vertices()];
        edgeTo = new int[unidirectedGraph.vertices()];
        distTo = new int[unidirectedGraph.vertices()];

        visit(unidirectedGraph, source);
    }

    // remove all nodes from a unidirectedGraph using BFS
    public void visit(UnidirectedGraph unidirectedGraph, int start) {

        // add first element to a queue
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        marked[start] = true;

        // while the queue is not empty
        while (!queue.isEmpty()) {
            // poll
            Integer vertex = queue.poll();

            // go through adjacent
            Iterable<Integer> adjacent = unidirectedGraph.adjacent(vertex);
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
