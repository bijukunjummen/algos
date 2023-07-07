package org.bk.algo.core;


import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class MinPriorityQueueTest {
    @Test
    void testMinPriorityQueueWithSmallSetOfInts() {
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

    @Test
    void testBuiltInPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(9);
        pq.add(11);
        pq.add(2);
        pq.add(9);
        pq.add(19);
        pq.add(2);

        assertThat(pq.poll()).isEqualTo(2);
        assertThat(pq.poll()).isEqualTo(2);
        assertThat(pq.poll()).isEqualTo(9);
        assertThat(pq.poll()).isEqualTo(9);
        assertThat(pq.poll()).isEqualTo(11);
        assertThat(pq.poll()).isEqualTo(19);
    }

}
