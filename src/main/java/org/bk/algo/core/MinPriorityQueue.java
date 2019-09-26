package org.bk.algo.core;

public class MinPriorityQueue<T extends Comparable<? super T>> {
    private int size;
    private T[] pq;

    @SuppressWarnings("unchecked")
    public MinPriorityQueue(int maxSize) {
        this.pq = (T[]) new Comparable[maxSize];
    }

    public T delAndGetMin() {
        T toReturn = pq[1];
        exchange(1, this.size);
        pq[this.size] = null;
        this.size--;
        sink(1);
        return toReturn;
    }

    public void insert(T item) {
        pq[++this.size] = item;
        swim(this.size);
    }

    private void swim(int v) {
        int k = v;
        while (k > 1 && isLess(k, k / 2)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int v) {
        int k = v;

        while (2 * k <= this.size) {
            int i = 2 * k;
            if (i < this.size && isLess(i + 1, i)) {
                i = i + 1;
            }
            if (isLess(i, k)) {
                exchange(i, k);
            }
            k = i;
        }

    }

    private boolean isLess(int i, int j) {
        return (pq[i].compareTo(pq[j]) < 0);
    }


    private void exchange(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }


}
