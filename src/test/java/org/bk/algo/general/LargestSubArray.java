package org.bk.algo.general;

import org.junit.jupiter.api.Test;

class LargestSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int max = maxFor(nums, i);
            if (max > maxSum) {
                maxSum = max;
            }
        }
        return maxSum;
    }

    private int maxFor(int[] nums, int idx) {
        int currSum = nums[idx];
        int max = currSum;
        for (int i = idx + 1; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum > max) {
                max = currSum;
            }
        }
        return max;
    }

    @Test
    void testMaxSum() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


}