package week5.datacompression.huffman;

import edu.princeton.cs.algs4.MinPQ;

import java.io.ByteArrayOutputStream;

/**
 * Created by matijav on 12/02/2017.
 */
public class HuffmanCompression {
    private final char R = 256;
    private final char lgR = 8;
    private Node root;
    private int N;

    public HuffmanCompression() {
    }

    public void buildTrie(char[] input) {
        this.N = input.length;

        // compute frequencies to build the optimal tree
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++) {
            freq[input[i]]++;
        }

        // build tree
        root = buildTrie(freq);
    }

    public byte[] compress(char[] input) {

        // build code table
        String[] st = new String[R];
        buildCode(st, root, "");

        // encode
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    buffer.write(0);
                } else if (code.charAt(j) == '1') {
                    buffer.write(1);
                } else {
                    throw new IllegalStateException("Illegal state: " + code.charAt(i));
                }
            }
        }

        // flush
        flush(buffer);

        return buffer.toByteArray();
    }

    public char[] expand(byte[] encoded) {

        // decode
        int counter = 0;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                if (encoded[counter] == 0) {
                    x = x.left;
                } else if (encoded[counter] == 1) {
                    x = x.right;
                } else {
                    throw new IllegalStateException("Illegal state: " + encoded[i]);
                }
                counter++;
            }
            buffer.append(x.ch);
        }

        return buffer.toString().toCharArray();
    }

    private void flush(ByteArrayOutputStream buffer) {
        int padding = buffer.size() % lgR;
        if (padding != 0) {
            for (int i = 0; i < lgR - padding; i++) {
                buffer.write(0);
            }
        }
    }

    private void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + '0');
            buildCode(st, x.right, s + '1');
        } else {
            st[x.ch] = s;
        }
    }

    private Node buildTrie(int[] freq) {
        // init pq with singleton tries
        MinPQ<Node> pq = new MinPQ<>();
        for (char i = 0; i < R; i++) {
            if (freq[i] > 0) {
                pq.insert(new Node(i, freq[i], null, null));
            }
        }

        // merge two smallest tries
        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);  // \0 is dummy char, it's ignored in internal nodes
            pq.insert(parent);
        }

        return pq.delMin();
    }

    public Node unmarshalTrie(String trie) {
        return unmarshalTrie(trie, 0);
    }

    private Node unmarshalTrie(String trie, int pos) {
        if (trie.charAt(pos++) == '1') {
            char c = trie.charAt(pos + 1);
            return new Node(c, 0, null, null);
        }
        Node left = unmarshalTrie(trie, pos);
        Node right = unmarshalTrie(trie, pos);
        return new Node('\0', 0, left, right);     // ch is not used for internal nodes
    }

    public String marshalTrie() {
        StringBuilder buffer = new StringBuilder();
        marshalTrie(root, buffer);
        return buffer.toString();
    }

    private void marshalTrie(Node x, StringBuilder buffer) {
        if (x.isLeaf()) {
            buffer.append(1);
            buffer.append(x.ch);
            return;
        }
        buffer.append(0);
        marshalTrie(x.left, buffer);
        marshalTrie(x.right, buffer);
    }

    private class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }
}
