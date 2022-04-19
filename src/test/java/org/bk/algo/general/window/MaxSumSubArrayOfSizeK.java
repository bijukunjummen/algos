package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int s = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int e = 0; e < arr.length; e++) {
            sum += arr[e];
            if (e >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[s];
                s++;
            }
        }
        return maxSum;
    }

    @Test
    void testMaxSubarray() {
        assertThat(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2})).isEqualTo(9);
        assertThat(findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5})).isEqualTo(7);
    }
}