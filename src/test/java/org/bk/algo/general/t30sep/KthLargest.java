package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        for (int n : nums) {
            if (minPq.size() < k) {
                minPq.add(n);
            } else if (n > minPq.peek()) {
                minPq.poll();
                minPq.add(n);
            }
        }
        return minPq.peek();
    }

    @Test
    void testKth() {
        assertThat(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
        assertThat(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)).isEqualTo(4);
    }
}
