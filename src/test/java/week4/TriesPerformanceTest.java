package week4;

import org.junit.Test;
import week4.trie.TernarySearchTriesST;
import week4.trie.TrieST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matijav on 08/02/2017.
 */
public class TriesPerformanceTest {

    @Test
    public void test1() {
        TrieST<Boolean> trie = new TrieST<>();

        for (String s : randomWords()) {
            trie.put(s, true);
        }
        for (String s : randomWords()) {
            trie.contains(s);
        }
        for (String s : randomWords()) {
            trie.keysWithPrefix(s);
        }
    }

    @Test
    public void test2() {
        TernarySearchTriesST<Boolean> trie = new TernarySearchTriesST<>();

        for (String s : randomWords()) {
            trie.put(s, true);
        }
        for (String s : randomWords()) {
            trie.contains(s);
        }
        for (String s : randomWords()) {
            trie.keysWithPrefix(s);
        }
    }

    @Test
    public void test12() {
        TrieST<Boolean> trie = new TrieST<>();
        List<String> rw = randomWords();

        for (String s : rw) {
            trie.put(s, true);
        }
        for (String s : rw) {
            trie.contains(s);
        }
        for (String s : randomWords()) {
            trie.keysWithPrefix(s);
        }
    }

    @Test
    public void test22() {
        TernarySearchTriesST<Boolean> trie = new TernarySearchTriesST<>();
        List<String> rw = randomWords();

        for (String s : rw) {
            trie.put(s, true);
        }
        for (String s : rw) {
            trie.contains(s);
        }
        for (String s : randomWords()) {
            trie.keysWithPrefix(s);
        }
    }

    private List<String> randomWords() {
        double delta = 'Z' - 'A';
        double offset = 'A';

        List<String> words = new ArrayList<>();
        for (int j = 0; j < 20000; j++) {
            for (int i = 5; i < 12; i++) {
                String word = "";
                for (int k = 0; k < i; k++) {
                    char c = (char) (Math.random() * delta + offset);
                    word += c;
                }
                words.add(word);
            }
        }

        return words;
    }
}
