package org.bk.algo.core;

public class PriorityQueue<T extends Comparable<? super T>> {
    T[] pq;
    
    public PriorityQueue(T[] pq){
        this.pq = pq;
    }
    
    private boolean isLess(int i, int j){
        return (this.pq[i].compareTo(this.pq[j])<0);
    }
    
    private void exchange(int i, int j){
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    
    private void swim(int k){
        while (k>1 && isLess(k/2,k)){
            exchange(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){
        int N = pq.length;
        while (2*k<=N){
            int j = 2*k;
            if (j<N && isLess(j, j++)) j++;
            if (!isLess(k,j)) break;
            exchange(k,j);
            k = j;
        }
    }

}
