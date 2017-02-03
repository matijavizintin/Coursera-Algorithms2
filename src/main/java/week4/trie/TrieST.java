package week4.trie;

import edu.princeton.cs.algs4.Queue;
import week4.Backend;

/**
 * Created by matijav on 30/01/2017.
 */
public class TrieST<VAL> implements Backend<VAL> {
    private static final int R = 256;
    public boolean debug = false;
    public int debugCountNodes = 0;
    private Node root;

    public TrieST() {
    }

    public void put(String key, VAL value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, VAL value, int d) {
        if (x == null) {
            x = new Node();
            if (debug) {
                debugCountNodes++;
            }
        }

        if (d == key.length()) {
            x.value = value;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d + 1);
        return x;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public VAL get(String key) {
        Node x = get(root, key, 0);
        return x == null ? null : (VAL) x.value;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;

        if (d == key.length()) return x;

        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void delete(String key) {
        delete(root, key, 0);
    }

    private boolean delete(Node x, String key, int d) {
        if (x == null) return false;

        if (d == key.length()) {
            x.value = null;
            return true;
        }

        char c = key.charAt(d);
        boolean delete = delete(x.next[c], key, d + 1);
        if (delete) {
            x.next[c] = null;
        }

        return !hasAnyChildren(x);
    }

    private boolean hasAnyChildren(Node x) {
        for (Node node : x.next) {
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<String> keys() {
        Queue<String> q = new Queue<>();
        collect(root, "", q);
        return q;
    }

    private void collect(Node x, String prefix, Queue<String> q) {
        if (x == null) return;
        if (x.value != null) {
            q.enqueue(prefix);
        }

        for (char i = 0; i < R; i++) {
            collect(x.next[i], prefix + i, q);
        }
    }

    @Override
    public Iterable<String> keysWithPrefix(String prefix) {
        Node x = get(root, prefix, 0);
        Queue<String> q = new Queue<>();
        collect(x, prefix, q);
        return q;
    }

    @Override
    public String longestPrefixOf(String key) {
        int len = search(root, key, 0, 0);
        return key.substring(0, len);
    }

    private int search(Node x, String query, int d, int length) {
        if (x == null) return length;
        if (x.value != null) length = d;
        if (d == query.length()) return length;

        char c = query.charAt(d);
        return search(x.next[c], query, d + 1, length);
    }

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }
}
