package week1.graphs.unidirected;

import com.google.common.collect.ImmutableList;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Matija Vižintin
 * Date: 03. 11. 2015
 * Time: 21:30
 */
public class UndirectedGraph1 implements UndirectedGraph {
    private int verticesCount = 0;
    private int edgesCount = 0;

    private Map<Integer, Collection<Integer>> edges = new HashMap<>();

    public UndirectedGraph1(int v) {

    }

    public UndirectedGraph1(InputStream in) {

    }

    // add an edge from v to w
    public void addEdge(int v, int w) {
        // add v to w
        Collection<Integer> collection = edges.get(v);
        if (collection == null) {
            collection = new HashSet<>();
            edges.put(v, collection);

            // new vertex added
            verticesCount++;
        }
        boolean added = collection.add(w);
        if (added) edgesCount++;       // new edge added

        // add w to v
        collection = edges.get(w);
        if (collection == null) {
            collection = new HashSet<>();
            edges.put(w, collection);

            // new vertex added
            verticesCount++;
        }
        added = collection.add(v);
        if (added) edgesCount++;        // new edge added
    }

    // vertices adjacent to v
    public Iterable<Integer> adjacent(int v) {
        Collection<Integer> collection = edges.get(v);

        // defensive copy
        return collection == null ? ImmutableList.of() : ImmutableList.copyOf(collection);
    }

    // number of vertices
    public int vertices() {
        return verticesCount;
    }

    // number of edges
    public int edges() {
        return edgesCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v = 0; v < vertices(); v++) {
            for (Integer w : adjacent(v)) {
                stringBuilder.append(v).append(" - ").append(w).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
