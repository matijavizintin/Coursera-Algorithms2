package week3;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import week3.graphs.FlowEdge;
import week3.graphs.FlowNetwork;
import week3.maxflow.FordFulkerson;

/**
 * Created by Matija Vižintin
 * Date: 13. 12. 2015
 * Time: 19:13
 */
public class MaxFlowTest {

    @Test
    public void fordFulkersonTest() {
        FlowNetwork flowNetwork = buildFlowNetwork();

        // assert flow network
        Assert.assertEquals(8, flowNetwork.V());
        Assert.assertEquals(15, flowNetwork.E());
        Assert.assertEquals(15 * 2, Iterables.size(flowNetwork.edges()));

        // assert ford fulkerson
        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, 0, 7);
        double maxFlow = fordFulkerson.value();
        Assert.assertEquals(28, maxFlow, Math.pow(2, -9));
    }

    private FlowNetwork buildFlowNetwork() {
        FlowNetwork f = new FlowNetwork(8);
        f.addEdge(new FlowEdge(0, 1, 10));
        f.addEdge(new FlowEdge(1, 2, 9));
        f.addEdge(new FlowEdge(2, 7, 10));
        f.addEdge(new FlowEdge(0, 5, 5));
        f.addEdge(new FlowEdge(5, 6, 8));
        f.addEdge(new FlowEdge(6, 7, 10));
        f.addEdge(new FlowEdge(0, 3, 15));
        f.addEdge(new FlowEdge(3, 4, 16));
        f.addEdge(new FlowEdge(4, 7, 10));
        f.addEdge(new FlowEdge(1, 5, 4));
        f.addEdge(new FlowEdge(5, 3, 4));
        f.addEdge(new FlowEdge(1, 6, 15));
        f.addEdge(new FlowEdge(4, 5, 6));
        f.addEdge(new FlowEdge(2, 6, 15));
        f.addEdge(new FlowEdge(6, 4, 15));

        return f;
    }
}
