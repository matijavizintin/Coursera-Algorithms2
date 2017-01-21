package week2.mst;

import edu.princeton.cs.algs4.Queue;
import week2.structures.edges.UndirectedEdge;
import week2.structures.graphs.EdgeWeightedUndirectedGraph;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Home-made extra naive algorithm for computing mst.
 * <p>
 * This is basically made from pseudo code:
 * while (len(mst) < len(graph) -1)
 *    find cut with no black crossing edges
 *    add edge with min edge to black edges
 * <p>
 * Created by matijav on 21/01/2017.
 */
public class GreedyMST implements MST {
    private Set<UndirectedEdge> black;      // collection of black edges
    private Queue<UndirectedEdge> mst;      // minimum spanning tree
    private EdgeWeightedUndirectedGraph graph;

    public GreedyMST(EdgeWeightedUndirectedGraph graph) {
        black = new HashSet<>();
        mst = new Queue<>();
        this.graph = graph;

        // loop until we cover all vertices
        while (black.size() < graph.V() - 1) {
            // find a cut and find a min weight crossing edge
            Collection<Integer> cut = findCut(new HashSet<>(), 0);
            if (cut == null) {
                throw new RuntimeException("Error in algo.");
            }
            UndirectedEdge minWeightEdge = minWeightCrossingEdge(cut);

            // sanity check
            if (black.contains(minWeightEdge)) {
                throw new RuntimeException("Error in algo.");
            }

            mst.enqueue(minWeightEdge);
            black.add(minWeightEdge);
        }
    }

    // dummy recursive algorithm finds all possible cuts
    private Collection<Integer> findCut(Set<Integer> cut, int start) {
        // if size of cut len(graph) - 1 then return
        if (cut.size() >= graph.V() - 1) {
            return null;
        }

        for (int i = start; i < graph.V(); i++) {
            Collection<Integer> found = findCut1(cut);
            if (found != null) {
                return found;
            }

            if (!cut.contains(i)) {
                // node must be adjacent to current nodes in a cut
                if (!isAdjacent(cut, i)) {
                    continue;
                }

                // try recursively without current node
                Set<Integer> cut1 = new HashSet<>(cut);
                found = findCut(cut1, i + 1);
                if (found != null) {
                    return found;
                }

                // try recursively with current node
                Set<Integer> cut2 = new HashSet<>(cut);
                cut2.add(i);
                found = findCut(cut2, i + 1);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    // calculates if candidate id adjacent to vertices
    private boolean isAdjacent(Set<Integer> vertices, int candidate) {
        if (vertices.isEmpty()) {
            return true;
        }

        List<UndirectedEdge> adj = new ArrayList<>();
        vertices.forEach(v -> graph.adjacent(v).forEach(adj::add));

        return adj.stream().anyMatch(e -> e.isAny(candidate));
    }

    private Collection<Integer> findCut1(Set<Integer> cut) {
        OUT:
        for (int i = 0; i < graph.V(); i++) {
            if (cut.contains(i)) {
                continue;
            }
            if (!isAdjacent(cut, i)) {
                continue;
            }

            cut.add(i);

            List<UndirectedEdge> adj = new ArrayList<>();
            cut.forEach(v -> graph.adjacent(v).forEach(adj::add));

            // check if ALL adjacent edges aren't black that aren't in the cut
            for (UndirectedEdge undirectedEdge : adj) {
                // if edge is in the cut then is good
                if (cut.contains(undirectedEdge.either()) && cut.contains(undirectedEdge.other())) {
                    continue;
                }

                if (black.contains(undirectedEdge)) {
                    cut.remove(i);
                    continue OUT;   // found a black edge - not a valid cut
                }
            }
            return cut;
        }
        return null;
    }

    private UndirectedEdge minWeightCrossingEdge(Collection<Integer> cut) {
        List<UndirectedEdge> adj = new ArrayList<>();
        cut.forEach(v -> graph.adjacent(v).forEach(adj::add));

        // filter out non-crossing edges
        List<UndirectedEdge> filtered = adj.stream().filter(e -> !cut.contains(e.either()) || !cut.contains(e.other())).collect(Collectors.toList());

        return Collections.min(filtered);
    }

    @Override
    public Iterable<UndirectedEdge> edges() {
        return mst;
    }
}
