package week4.trie;

import week4.Backend;

/**
 * Created by matijav on 30/01/2017.
 */
public class TrieST<VAL> implements Backend<VAL> {
    private static final int R = 256;
    private Node root = new Node();

    public void put(String key, VAL value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, VAL value, int d) {
        if (x == null) x = new Node();

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

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }
}
