package org.bk.algo.core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MaxPriorityQueueTest {

    @Test
    public void testMaxPriorityQueueWithSmallSetOfInts() {
        MaxPriorityQueue<Integer> pq = new MaxPriorityQueue<Integer>(20);
        pq.insert(9);
        pq.insert(11);
        pq.insert(2);
        pq.insert(9);
        pq.insert(19);
        pq.insert(2);
        
        assertThat(pq.delAndGetMaximum(), is(equalTo(19)));
        assertThat(pq.delAndGetMaximum(), is(equalTo(11)));
        assertThat(pq.delAndGetMaximum(), is(equalTo(9)));
    }

}
