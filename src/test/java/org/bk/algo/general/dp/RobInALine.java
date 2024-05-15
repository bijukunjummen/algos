package org.bk.algo.general.dp;

import org.junit.jupiter.api.Test;

class RobInALine {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i-- ) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }

    @Test
    void testRob() {

    }
}