package week2;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import week2.graphs.Edge;
import week2.graphs.EdgeWeightedGraph;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 19:06
 */
public class GraphBuilderHelper {
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
        nodesMap.put(10, "K");
        nodesMap.put(11, "L");
        nodesMap.put(12, "M");
        nodesMap.put(13, "N");
        nodesMap.put(14, "O");
        nodesMap.put(15, "P");
        nodesMap.put(16, "R");
    }

    public static <GRAPH extends EdgeWeightedGraph<EDGE>, EDGE extends Edge> GRAPH convertToGraph(String input, String nodeDelimiter, GRAPH g) {
        for (String s : input.split("\n")) {
            s = s.trim();
            char firstNode = s.charAt(0);
            s = s.replace(nodeDelimiter, "");
            char secondNode = s.charAt(1);
            double weight = Double.parseDouble(s.substring(2).trim());

            g.addEdge(nodesMap.inverse().get(String.valueOf(firstNode)), nodesMap.inverse().get(String.valueOf(secondNode)), weight);
        }
        return g;
    }

    public static List<Integer> parseTopologicalOrder(String s) {
        return s.replace(" ", "").chars()
                .mapToObj(value -> nodesMap.inverse().get(String.valueOf((char)value)))
                .collect(Collectors.toList());
    }
}
