package week1.graphs.algorithms;

import week1.graphs.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Matija Vižintin
 * Date: 11. 11. 2015
 * Time: 19:39
 */
public class MultiSourceBFS extends BreadthFirstSearch {

    public MultiSourceBFS(Graph graph, Iterable<Integer> nodes) {
        super(graph);

        visit(graph, nodes);
    }

    private void visit(Graph graph, Iterable<Integer> nodes) {
        // add elements to a queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (Integer node : nodes) {
            queue.add(node);
            marked[node] = true;
        }

        visit(graph, queue);
    }
}
