package week3;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import week3.graphs.FlowEdge;
import week3.graphs.FlowNetwork;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 19:06
 */
public class NetworkBuilderHelper {
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

    public static FlowNetwork convertToNetwork(String input, String nodeDelimiter, int size) {
        FlowNetwork flowNetwork = new FlowNetwork(size);
        for (String s : input.split("\n")) {
            s = s.trim();
            char firstNode = s.charAt(0);
            s = s.replace(nodeDelimiter, "");
            char secondNode = s.charAt(1);

            s = s.substring(2).trim();
            String[] split = s.split("/");

            double flow = Double.parseDouble(split[0].trim());
            double capacity = Double.parseDouble(split[1].trim());

            int w = nodesMap.inverse().get(String.valueOf(secondNode));
            FlowEdge flowEdge = new FlowEdge(nodesMap.inverse().get(String.valueOf(firstNode)), w, capacity);
            flowEdge.addResidualFlowTo(w, flow);
            flowNetwork.addEdge(flowEdge);
        }
        return flowNetwork;
    }
}
