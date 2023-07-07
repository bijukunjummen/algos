package org.bk.algo.core;


import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxPriorityQueueTest {

    @Test
    public void testMaxPriorityQueueWithSmallSetOfInts() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<>(20);
        pq.insert(9);
        pq.insert(11);
        pq.insert(2);
        pq.insert(9);
        pq.insert(19);
        pq.insert(2);

        assertThat(pq.delAndGetMaximum()).isEqualTo(19);
        assertThat(pq.delAndGetMaximum()).isEqualTo(11);
        assertThat(pq.delAndGetMaximum()).isEqualTo(9);
    }

    @Test
    public void testMaxPriorityQueueWithStrings() {
        MaxPriorityQueue<String> pq = new MaxPriorityQueue<String>(14);
        pq.insert("Y");
        pq.insert("W");
        pq.insert("U");
        pq.insert("G");
        pq.insert("K");
        pq.insert("N");
        pq.insert("T");
        pq.insert("D");
        pq.insert("E");
        pq.insert("F");


        pq.delAndGetMaximum();
        pq.delAndGetMaximum();
        pq.delAndGetMaximum();

        assertThat(pq.delAndGetMaximum()).isEqualTo("T");
    }

    @Test
    void testBuiltInPriorityQueueTest() {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());

        maxPq.add(9);
        maxPq.add(11);
        maxPq.add(2);
        maxPq.add(9);
        maxPq.add(19);
        maxPq.add(2);

        assertThat(maxPq.poll()).isEqualTo(19);
        assertThat(maxPq.poll()).isEqualTo(11);
        assertThat(maxPq.poll()).isEqualTo(9);
    }

}
