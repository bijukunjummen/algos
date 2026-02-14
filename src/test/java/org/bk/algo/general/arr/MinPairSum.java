package org.bk.algo.general.arr;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int s = 0, e = n - 1; s < e; s++, e--) {
            int sum = nums[s] + nums[e];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    @Test
    void testMinPairSum() {
        assertThat(minPairSum(new int[]{3, 5, 2, 3})).isEqualTo(7);
        assertThat(minPairSum(new int[]{4,1,5,1,2,5,1,5,5,4})).isEqualTo(8);
    }
}
