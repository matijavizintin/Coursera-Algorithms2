package week2;

import org.junit.Test;
import week2.structures.graphs.EdgeWeightedDirectedGraph;
import week2.shortestpaths.BellmanFordShortestPaths;
import week2.shortestpaths.DijkstraShortestPaths;
import week2.shortestpaths.EdgeWeightedDAGShortestPaths;

import java.util.List;

/**
 * Created by Matija Vižintin
 * Date: 05. 12. 2015
 * Time: 19:05
 */
public class SPAssignment {

    @Test
    public void quiz1() {
        DijkstraShortestPaths dsp = new DijkstraShortestPaths(buildGraph(), GraphBuilderHelper.nodesMap.inverse().get("D"));
        System.out.println("target: " + GraphBuilderHelper.nodesMap.inverse().get("F"));
    }

    @Test
    public void quiz2() {
        List<Integer> debugForcedTopological = GraphBuilderHelper.parseTopologicalOrder("F G D H B C E A ");
        EdgeWeightedDAGShortestPaths sp =
                new EdgeWeightedDAGShortestPaths(buildGraph2(), GraphBuilderHelper.nodesMap.inverse().get("F"), debugForcedTopological);
        System.out.println("target: " + GraphBuilderHelper.nodesMap.inverse().get("B"));
    }

    @Test
    public void quiz3() {
        BellmanFordShortestPaths sp = new BellmanFordShortestPaths(buildGraph3(), GraphBuilderHelper.nodesMap.inverse().get("H"));
    }

    private EdgeWeightedDirectedGraph buildGraph() {
        String s = "B->A   119\n" +
                   "    B->F    38\n" +
                   "    B->G    10\n" +
                   "    C->B    15\n" +
                   "    C->G    29\n" +
                   "    D->C     4\n" +
                   "    D->G    37\n" +
                   "    D->H    10\n" +
                   "    E->A    36\n" +
                   "    F->A    76\n" +
                   "    F->E    38\n" +
                   "    F->G     3\n" +
                   "    H->G    26";

        return GraphBuilderHelper.convertToGraph(s, "->", new EdgeWeightedDirectedGraph(8));
    }

    private EdgeWeightedDirectedGraph buildGraph2() {
        String s = "B->A    10\n" +
                   "    B->C     8\n" +
                   "    B->E     4\n" +
                   "    D->C    13\n" +
                   "    D->H    39\n" +
                   "    E->A    28\n" +
                   "    F->B    42\n" +
                   "    F->E     5\n" +
                   "    F->G     8\n" +
                   "    G->B    25\n" +
                   "    G->C    34\n" +
                   "    G->D    22\n" +
                   "    G->H    70";

        return GraphBuilderHelper.convertToGraph(s, "->", new EdgeWeightedDirectedGraph(8));
    }

    private EdgeWeightedDirectedGraph buildGraph3() {
        String s = "B->A    14\n" +
                   "    B->C    24\n" +
                   "    C->D     1\n" +
                   "    E->A    11\n" +
                   "    F->B    33\n" +
                   "    F->A    46\n" +
                   "    F->E    32\n" +
                   "    G->B    50\n" +
                   "    G->C    76\n" +
                   "    G->D     3\n" +
                   "    G->F    14\n" +
                   "    H->D     0\n" +
                   "    H->G     8";
        return GraphBuilderHelper.convertToGraph(s, "->", new EdgeWeightedDirectedGraph(8));
    }
}
