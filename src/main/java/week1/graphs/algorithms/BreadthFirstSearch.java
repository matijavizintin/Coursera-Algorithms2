package week1.graphs.algorithms;

import week1.graphs.Graph;

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

    public BreadthFirstSearch(Graph graph) {
        marked = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
        distTo = new int[graph.vertices()];
    }

    public BreadthFirstSearch(Graph graph, int source) {
        this(graph);

        visit(graph, source);
    }

    public void visit(Graph graph, int start) {
        // add first element to a queue
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        marked[start] = true;

        visit(graph, queue);
    }

    // go through all nodes using BFS
    protected void visit(Graph graph, Queue<Integer> queue) {

        // while the queue is not empty
        while (!queue.isEmpty()) {
            // poll
            Integer vertex = queue.poll();

            // go through adjacent
            Iterable<Integer> adjacent = graph.adjacent(vertex);
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
