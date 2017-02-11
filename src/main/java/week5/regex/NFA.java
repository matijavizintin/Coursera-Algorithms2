package week5.regex;

import com.google.common.collect.Lists;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;
import week1.graphs.directed.DirectGraphImpl;
import week1.graphs.directed.DirectedGraph;

import java.util.Collections;
import java.util.List;

/**
 * Created by matijav on 11/02/2017.
 */
public class NFA {
    public boolean DEBUG = false;

    private char[] regex;
    private DirectedGraph<Integer> graph;
    private int M;                          // number of states

    public NFA(String regex) {
        regex = validateRegex(regex);

        M = regex.length();
        this.regex = regex.toCharArray();
        graph = buildEpsilonTransitionDigraph();
    }

    public boolean recognizes(String text) {
        // compute states reachable from start by epsilon-transitions
        Bag<Integer> pc = new Bag<>();      // PC (program counter) ==> all possible states that NFA could be in
        DirectedDFS dfs = new DirectedDFS(graph, 0);    // build graph to compute al possible states from 0
        for (int v = 0; v < graph.V(); v++) {
            if (dfs.marked(v)) pc.add(v);
        }

        // go through text
        for (int i = 0; i < text.length(); i++) {
            // compute states directly reachable after scanning each char in text
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v == M) continue;

                // if regex matches then add next character to states
                if ((regex[v] == text.charAt(i)) || regex[v] == '.') {
                    match.add(v + 1);
                }
            }

            // compute new states reachable by epsilon-transitions
            dfs = new DirectedDFS(graph, match);
            pc = new Bag<>();
            for (int v = 0; v < graph.V(); v++) {
                if (dfs.marked(v)) pc.add(v);
            }
        }

        if (DEBUG) {
            List<Integer> list = Lists.newArrayList(pc);
            Collections.sort(list);
            list.forEach(x -> System.out.print(x + " "));
        }

        // accept if can end in final state (==M)
        for (int v : pc) {
            if (v == M) return true;
        }
        return false;
    }

    // builds only epsilon transitions, not connection between regular character
    private DirectedGraph<Integer> buildEpsilonTransitionDigraph() {
        DirectedGraph<Integer> graph = new DirectGraphImpl(M + 1);
        Stack<Integer> ops = new Stack<>();

        for (int i = 0; i < M; i++) {
            int lp = i;

            // if lp (left parenthesis) or an 'or' operator then push to stack
            if (regex[i] == '(' || regex[i] == '|') {
                ops.push(i);
            }
            // if rp (right parenthesis) then pop the stack
            else if (regex[i] == ')') {
                int elem = ops.pop();

                // if 'or' on stack then connect lp with or + 1 and or with rp
                if (regex[elem] == '|') {
                    lp = ops.pop();
                    graph.addEdge(lp, elem + 1);
                    graph.addEdge(elem, i);
                } else {
                    lp = elem;  // elem is lp
                }
            }

            // if next element is a closure create loop from lp to * and vice versa
            if (i < M - 1 && regex[i + 1] == '*') {
                graph.addEdge(lp, i + 1);
                graph.addEdge(i + 1, lp);
            }

            // meta-symbols
            if (regex[i] == '(' || regex[i] == '*' || regex[i] == ')') {
                graph.addEdge(i, i + 1);
            }
        }
        return graph;
    }

    private String validateRegex(String regex) {
        if (regex.charAt(0) != '(' || regex.charAt(regex.length() - 1) != ')') {
            regex = '(' + regex + ')';
        }
        return regex;
    }

    public void debugPrintGraph() {
        System.out.println(graph);
    }
}
