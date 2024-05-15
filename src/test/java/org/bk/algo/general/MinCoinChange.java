package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinCoinChange {
    public int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount, 0);
    }

    private int coinChange(int idx, int[] coins, int amount, int coinCount) {
//        System.out.println(idx);
        if (idx >= coins.length || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return coinCount;
        }
        int coinCountPath1 = coinChange(idx, coins, amount - coins[coins.length - idx - 1], coinCount + 1);
        int coinCountPath2 = coinChange(idx + 1, coins, amount, coinCount);

        if (coinCountPath1 == -1 && coinCountPath2 == -1) {
            return -1;
        } else if (coinCountPath1 == -1 && coinCountPath2 >= 0) {
            return coinCountPath2;
        } else if (coinCountPath1 >= 0 && coinCountPath2 == -1) {
            return coinCountPath1;
        } else {
            return Math.min(coinCountPath1, coinCountPath2);
        }
    }


    @Test
    void testMinCoinChange() {
        assertThat(coinChange(new int[]{1, 2, 5}, 11)).isEqualTo(3);
        assertThat(coinChange(new int[]{1, 2, 5}, 11)).isEqualTo(3);
    }

    @Test
    void testLargeIter1() {
        assertThat(coinChange(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}, 9864))
                .isEqualTo(24);
    }

}