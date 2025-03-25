package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MinCoinChange {
    private static final int NOT_SET = -2;

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, NOT_SET);
        return coinChange(coins, amount, 0, memo);
    }

    private int coinChange(int[] coins, int amount, int moves, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (memo[amount] != NOT_SET) {
            return memo[amount];
        }

        int minMoves = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChange(coins, amount - coin, moves + 1, memo);
            if (result != -1) {
                minMoves = Math.min(minMoves, result);
            }
        }
        int minForAmount = minMoves == Integer.MAX_VALUE ? -1 : minMoves + 1;
        memo[amount] = minForAmount;
        return minForAmount;
    }



    @Test
    void testMinCoinChange() {
        assertThat(coinChange(new int[]{1, 2, 5}, 11)).isEqualTo(3);
    }

    @Test
    void testLargeIter1() {
        assertThat(coinChange(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}, 9864))
                .isEqualTo(24);
    }

}