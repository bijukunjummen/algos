package org.bk.algo.general.arr;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MinRemoval {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int r = 0;
        for (int s = 0; s <  n; s++) {
            long upto = nums[s] * k;
            while (r < n && nums[r] <= upto) {
               r++;
            }
            min = Math.min(min, n - (r - s) );
        }
        return min;
    }

    @Test
    void testMinRemoval() {
        assertThat(minRemoval(new int[]{2, 1, 5}, 2)).isEqualTo(1);
        assertThat(minRemoval(new int[]{1, 6, 2, 9}, 3)).isEqualTo(2);
        assertThat(minRemoval(new int[]{1, 34, 23}, 2)).isEqualTo(1);
        assertThat(minRemoval(new int[]{8}, 1)).isEqualTo(0);
        assertThat(minRemoval(new int[]{8,99,65,16,39}, 3)).isEqualTo(2);
    }

}