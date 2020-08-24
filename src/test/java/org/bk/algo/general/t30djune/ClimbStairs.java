package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n;i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        return climbStairs(n, dp);
    }
    
    private int climbStairs(int n, int[] dp) {
        if (n < 0) return 0;
        
        if (dp[n] != -1) {
            return dp[n];
        }
        int res  = climbStairs(n - 1, dp) + climbStairs(n-2, dp);
        dp[n] = res;
        return res;
    }

    @Test
    void testClimbStairs() {
        assertThat(climbStairs(0)).isEqualTo(1);
        assertThat(climbStairs(1)).isEqualTo(1);
        assertThat(climbStairs(2)).isEqualTo(2);
        assertThat(climbStairs(3)).isEqualTo(3);
    }
}