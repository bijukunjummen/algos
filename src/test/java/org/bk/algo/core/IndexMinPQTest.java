package org.bk.algo.core;


import org.junit.jupiter.api.Test;

public class IndexMinPQTest {
    @Test
    public void testMinPriorityQueueWithSmallSetOfInts() {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(10);
        minPQ.insert(0, 1);
        minPQ.insert(1, 10);
        minPQ.insert(2, 6);
        minPQ.insert(3, 4);
        minPQ.insert(4, 3);
        minPQ.insert(5, 2);
        minPQ.insert(6, 11);
        minPQ.insert(7, 5);
        
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
        System.out.println(minPQ.delMin());
    }
}
