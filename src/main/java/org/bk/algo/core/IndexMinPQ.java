package org.bk.algo.core;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int N;     
    private int[] pq;
    private int[] qp;
    private Key[] keys;
    
    public IndexMinPQ(int NMAX) {
        keys = (Key[]) new Comparable[NMAX + 1]; 
        pq   = new int[NMAX + 1];
        qp   = new int[NMAX + 1];   
        for (int i = 0; i <= NMAX; i++) qp[i] = -1;
    }

    public boolean isEmpty() { return N == 0; }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public int size() {
        return N;
    }

    public void insert(int k, Key key) {
        if (contains(k)) throw new RuntimeException("item is already in pq");
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public int min() { 
        if (N == 0) throw new RuntimeException("Priority queue underflow");
        return pq[1];        
    }

    public Key minKey() { 
        if (N == 0) throw new RuntimeException("Priority queue underflow");
        return keys[pq[1]];        
    }

    public int delMin() { 
        if (N == 0) throw new RuntimeException("Priority queue underflow");
        int min = pq[1];        
        exch(1, N--); 
        sink(1);
        qp[min] = -1;      
        keys[pq[N+1]] = null; 
        pq[N+1] = -1;          
        return min; 
    }

    public void change(int k, Key key) {
        if (!contains(k)) throw new RuntimeException("item is not in pq");
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void decrease(int k, Key key) {
        if (!contains(k)) throw new RuntimeException("item is not in pq");
        if (keys[k].compareTo(key) <= 0) throw new RuntimeException("illegal decrease");
        keys[k] = key;
        swim(qp[k]);
    }

    public void increase(int k, Key key) {
        if (!contains(k)) throw new RuntimeException("item is not in pq");
        if (keys[k].compareTo(key) >= 0) throw new RuntimeException("illegal decrease");
        keys[k] = key;
        sink(qp[k]);
    }


    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i]; pq[i] = pq[j]; pq[j] = swap;
        qp[pq[i]] = i; qp[pq[j]] = j;
    }


    private void swim(int k)  {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public Iterator<Integer> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Integer> {
        private IndexMinPQ<Key> copy;

        public HeapIterator() {
            copy = new IndexMinPQ<Key>(pq.length - 1);
            for (int i = 1; i <= N; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}
