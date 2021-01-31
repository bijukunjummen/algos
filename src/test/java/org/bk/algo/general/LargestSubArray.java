package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LargestSubArray {

    // also known as Kedane's algorithm..
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        int max = Integer.MIN_VALUE;
        memo[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(nums[i], memo[i - 1] + nums[i]);
            max = Math.max(max, memo[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int win = 1; win <= nums.length; win++) {
            for (int i = 0; i <= nums.length - win; i++) {
                int startIndex = i;
                int endIndex = (i + win - 1);
                int sum = sums[endIndex + 1] - sums[startIndex];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int win = 1; win <= nums.length; win++) {
            int sum = sumSub(nums, 0, win);
            if (sum > max) {
                max = sum;
            }
            for (int i = 1; i <= nums.length - win; i++) {
                sum -= nums[i - 1];
                sum += nums[i + win - 1];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private int sumSub(int[] nums, int p, int win) {
        int sum = 0;
        for (int i = p; i <= p + win - 1; i++) {
            sum += nums[i];
        }
        return sum;
    }

    @Test
    void testMaxSum() {
        Assertions.assertThat(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);
    }
}