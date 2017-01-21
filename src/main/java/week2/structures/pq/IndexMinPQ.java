package week2.structures.pq;

import java.util.NoSuchElementException;

/**
 * Created by matijav on 21/01/2017.
 */
public class IndexMinPQ<KEY extends Comparable<KEY>> {
    private KEY[] keys; // priority of key
    private int[] pq;   // priority q - index of the key in heap
    private int[] qp;   // heap position of the key --> inverted pq
    private int N;
    private int maxN;

    public IndexMinPQ(int maxN) {
        keys = (KEY[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        this.N = 0;
        this.maxN = maxN;

        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    // associate key with index i
    public void insert(int i, KEY key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (contains(i)) throw new IllegalArgumentException();

        N++;
        qp[i] = N;
        pq[N] = i;

        keys[i] = key;
        swim(N);
    }

    // decrease the key associate with index i
    public void decreaseKey(int i, KEY key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException();

        // validate that new key is lower than the existing key
        if (keys[i].compareTo(key) <= 0) {
            throw new IllegalArgumentException();
        }

        keys[i] = key;
        swim(qp[i]);
    }

    public boolean contains(int i) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();

        return qp[i] != -1;
    }

    public KEY minKey() {
        if (isEmpty()) throw new NoSuchElementException();
        return keys[pq[1]];
    }

    // removes the min key and returns it's associated index
    public int delMin() {
        if (isEmpty()) throw new NoSuchElementException();

        int min = pq[1];
        exch(1, N--);
        sink(1);

        qp[min] = -1;
        keys[pq[N + 1]] = null;
        pq[N + 1] = -1;

        return min;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // swim the element to the root
    private void swim(int i) {
        // until we are not at the root and child is greater of the parent
        while (i > 1 && greater(i / 2, i)) {
            exch(i, i / 2);
            i = i / 2;
        }
    }

    // sink the element to the leaf
    private void sink(int i) {
        // until we are not at the leaf
        while (2 * i <= N) {
            int j = 2 * i;  // child index
            if (j < N && greater(j, j + 1)) j++;    // choose child
            if (!greater(i, j)) break;      // if parent < child then break
            exch(i, j);
            i = j;
        }
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
