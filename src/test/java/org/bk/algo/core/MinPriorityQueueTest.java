package org.bk.algo.core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

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
        
        assertThat(pq.delAndGetMin(), is(equalTo(2)));
        assertThat(pq.delAndGetMin(), is(equalTo(2)));
        assertThat(pq.delAndGetMin(), is(equalTo(9)));
        assertThat(pq.delAndGetMin(), is(equalTo(9)));
        assertThat(pq.delAndGetMin(), is(equalTo(11)));
        assertThat(pq.delAndGetMin(), is(equalTo(19)));
    }

}
