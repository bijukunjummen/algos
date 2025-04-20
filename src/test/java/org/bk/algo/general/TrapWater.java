package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class TrapWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = 0;
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i - 1]);
        }

        rmax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i + 1]);
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            int p = Math.min(lmax[i], rmax[i]) - height[i];
            total +=  p > 0? p:0;
        }
        return total;
    }

    @Test
    void testTrap() {
        assertThat(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
        assertThat(trap(new int[]{4, 2, 0, 3, 2, 5})).isEqualTo(9);
    }
}
