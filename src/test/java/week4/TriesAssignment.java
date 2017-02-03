package week4;

import org.junit.Test;
import week4.trie.TernarySearchTriesST;
import week4.trie.TrieST;

/**
 * Created by matijav on 31/01/2017.
 */
public class TriesAssignment {

    @Test
    public void test1() {
        TrieST<Integer> trie = new TrieST<>();
        trie.debug = true;
        loadTrie("133 3111 22 1121 131 311 123", trie);
        System.out.println("Nodes created: " + trie.debugCountNodes);
    }

    @Test
    public void test2() {
        TernarySearchTriesST<Integer> trie = new TernarySearchTriesST<>();
        trie.debug = true;
        loadTrie("331 115 415 135 145 112 532", trie);
    }

    private void loadTrie(String input, Backend<Integer> trie) {
        String[] parts = input.split(" ");
        for (int i = 0; i < parts.length; i++) {
            trie.put(parts[i], i);
        }
    }
}
