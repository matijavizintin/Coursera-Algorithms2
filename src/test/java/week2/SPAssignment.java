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
        List<Integer> debugForcedTopological = GraphBuilderHelper.parseTopologicalOrder("F G H D C B E A");
        EdgeWeightedDAGShortestPaths sp =
                new EdgeWeightedDAGShortestPaths(buildGraph2(), GraphBuilderHelper.nodesMap.inverse().get("F"), debugForcedTopological);
        System.out.println("target: " + GraphBuilderHelper.nodesMap.inverse().get("B"));
    }

    @Test
    public void quiz3() {
        BellmanFordShortestPaths sp = new BellmanFordShortestPaths(buildGraph3(), GraphBuilderHelper.nodesMap.inverse().get("F"));
    }

    private EdgeWeightedDirectedGraph buildGraph() {
        String s = "A->E    23\n" +
                "    A->F     2\n" +
                "    B->A    10\n" +
                "    B->F     9\n" +
                "    C->B    56\n" +
                "    D->C    24\n" +
                "    D->G    47\n" +
                "    D->H     6\n" +
                "    F->E    28\n" +
                "    G->B    37\n" +
                "    G->C     1\n" +
                "    G->F    51\n" +
                "    H->G    34";

        return GraphBuilderHelper.convertToGraph(s, "->", new EdgeWeightedDirectedGraph(8));
    }

    private EdgeWeightedDirectedGraph buildGraph2() {
        String s = "B->A     1\n" +
                "    B->E     1\n" +
                "    C->B    21\n" +
                "    D->C     3\n" +
                "    E->A    15\n" +
                "    F->B    75\n" +
                "    F->C    54\n" +
                "    F->E    28\n" +
                "    F->G    18\n" +
                "    G->C    26\n" +
                "    G->D    47\n" +
                "    G->H    29\n" +
                "    H->D    14";

        return GraphBuilderHelper.convertToGraph(s, "->", new EdgeWeightedDirectedGraph(8));
    }

    private EdgeWeightedDirectedGraph buildGraph3() {
        String s = "B->A    18\n" +
                "    B->E     2\n" +
                "    C->B    27\n" +
                "    D->C     1\n" +
                "    D->H    26\n" +
                "    E->A    72\n" +
                "    F->B    57\n" +
                "    F->E     4\n" +
                "    F->G     7\n" +
                "    F->C    30\n" +
                "    G->C    18\n" +
                "    G->D    15\n" +
                "    G->H    34";
        return GraphBuilderHelper.convertToGraph(s, "->", new EdgeWeightedDirectedGraph(8));
    }
}
