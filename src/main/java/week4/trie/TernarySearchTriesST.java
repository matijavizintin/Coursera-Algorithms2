package week4.trie;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by matijav on 31/01/2017.
 */
public class TernarySearchTriesST<VAL> implements Backend<VAL> {
    public boolean debug = false;
    private Node root;

    @Override
    public void put(String key, VAL val) {
        root = put(root, key, val, 0, 0);
    }

    private Node put(Node node, String key, VAL val, int d, int debugDepth) {
        char c = key.charAt(d);
        if (node == null) {
            node = new Node();
            node.c = c;
        }

        if (c < node.c) {
            node.left = put(node.left, key, val, d, debugDepth + 1);
        } else if (c > node.c) {
            node.right = put(node.right, key, val, d, debugDepth + 1);
        } else if (d < key.length() - 1) {
            node.mid = put(node.mid, key, val, d + 1, debugDepth + 1);
        } else {
            node.value = val;
            if (debug) {
                System.out.print(debugDepth + " ");
            }
        }
        return node;
    }

    @Override
    public VAL get(String key) {
        Node x = get(root, key, 0);
        return x == null ? null : x.value;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;

        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }

    @Override
    public boolean contains(String key) {
        return get(key) != null;
    }

    @Override
    public void delete(String key) {
        delete(root, key, 0);
    }

    private void delete(Node x, String key, int d) {
        if (x == null) return;

        char c = key.charAt(d);
        if (c < x.c) {
            delete(x.left, key, d);
        } else if (c > x.c) {
            delete(x.right, key, d);
        } else if (d < key.length() - 1) {
            delete(x.mid, key, d + 1);
        } else {
            x.value = null;
        }
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
            q.enqueue(prefix + x.c);
        }

        collect(x.left, prefix, q);
        collect(x.mid, prefix + x.c, q);
        collect(x.right, prefix, q);
    }

    @Override
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> q = new Queue<>();
        Node x = get(root, prefix, 0);
        if (x == null) return q;

        collect(x.left, prefix, q);
        collect(x.mid, prefix, q);
        collect(x.right, prefix, q);
        return q;
    }

    @Override
    public String longestPrefixOf(String key) {
        int len = search(root, key, 1, 0);
        return key.substring(0, len);
    }

    private int search(Node x, String query, int d, int length) {
        if (x == null) return length;
        if (x.value != null) length = d;

        char c = query.charAt(d);
        if (c < x.c) {
            return search(x.left, query, d, length);
        } else if (c > x.c) {
            return search(x.right, query, d, length);
        } else if (d < query.length() - 1) {
            return search(x.mid, query, d + 1, length);
        } else {
            return length;
        }
    }

    private class Node {
        private VAL value;
        private char c;
        private Node left, mid, right;
    }
}
