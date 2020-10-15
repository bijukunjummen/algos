package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class KthLargest {

    PriorityQueue<Integer> maxPq = null;
    private int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        maxPq = new PriorityQueue<>(k);
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (maxPq.size() < k) {
            maxPq.add(val);
        } else if (maxPq.size() == k) {
            Integer currentMax = maxPq.peek();
            if (val > currentMax) {
                maxPq.poll();
                maxPq.add(val);
            }
        }
        return maxPq.peek();
    }
}

class TestKthLargest {
    @Test
    void testKth() {
        KthLargest largest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertThat(largest.add(3)).isEqualTo(4);
        assertThat(largest.add(5)).isEqualTo(5);
        assertThat(largest.add(10)).isEqualTo(5);
        assertThat(largest.add(9)).isEqualTo(8);
        assertThat(largest.add(4)).isEqualTo(8);
    }
}