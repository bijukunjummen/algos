package org.bk.algo.core;

import java.lang.reflect.Array;

public class MaxPriorityQueue<T extends Comparable<? super T>> {
    T[] pq;
    int N=0;
    
    public MaxPriorityQueue(int maxSize){
        this.pq = (T[])new Comparable[maxSize];
    }

    public void insert(T v){
        pq[++N] = v;
        swim(N);
    }
    
    public T delAndGetMaximum(){
        T max = pq[1];
        exchange(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
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
        boolean isHeaped = false;
        while (!isHeaped && 2*k<=this.N){
            int j = 2*k;
            if (j<this.N && isLess(j, j+1)) j++;
            if (!isLess(k,j)) break;
            exchange(k,j);
            k = j;
        }
    }

}
