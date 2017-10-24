package week6;

import org.junit.Test;
import week1.GraphBuilder;
import week1.graphs.Graph;
import week1.graphs.directed.DirectGraphImpl;

public class HamiltonPathTest {

    @Test
    public void testHamiltonPath() {
        Graph graph = GraphBuilder.buildGraphForHamilton(DirectGraphImpl.class);

        HamiltonPath path = new HamiltonPath(graph);
        int cnt = path.count();
        System.out.println("cnt = " + cnt);
    }
}
