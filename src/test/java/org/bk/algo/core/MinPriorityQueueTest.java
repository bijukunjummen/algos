package org.bk.algo.core;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinPriorityQueueTest {
    @Test
    public void testMinPriorityQueueWithSmallSetOfInts() {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>(20);
        pq.insert(9);
        pq.insert(11);
        pq.insert(2);
        pq.insert(9);
        pq.insert(19);
        pq.insert(2);
        
        assertThat(pq.delAndGetMin()).isEqualTo(2);
        assertThat(pq.delAndGetMin()).isEqualTo(2);
        assertThat(pq.delAndGetMin()).isEqualTo(9);
        assertThat(pq.delAndGetMin()).isEqualTo(9);
        assertThat(pq.delAndGetMin()).isEqualTo(11);
        assertThat(pq.delAndGetMin()).isEqualTo(19);
    }
}
