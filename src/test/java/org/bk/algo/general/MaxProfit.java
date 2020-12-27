package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    @Test
    void testSamples() {
        assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
    }

    @Test
    void testIncreasing() {
        assertThat(maxProfit(new int[]{1, 2, 3, 4, 5})).isEqualTo(4);
    }

    @Test
    void testSample() {
        assertThat(maxProfit(new int[]{2, 2, 5})).isEqualTo(3);
    }

    @Test
    void testEmpty() {
        assertThat(maxProfit(new int[]{})).isEqualTo(0);
    }

}