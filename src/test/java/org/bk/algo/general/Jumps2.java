package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

class Jumps2 {
    public int jump(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] jumps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            jumps[i] = -1;
        }
        jumps[0] = 0;
        boolean[] visited = new boolean[nums.length];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            int jmax = nums[idx];
            for (int j = 1; j <= jmax && (idx + j) < nums.length; j++) {
                int nextIdx = idx + j;
                if (!visited[nextIdx]) {
                    jumps[nextIdx] = jumps[idx] + 1;
                    visited[nextIdx] = true;
                    queue.add(nextIdx);
                }
            }
        }
        return jumps[nums.length - 1];
    }

    @Test
    void testJumps() {
        assertThat(jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
    }
}