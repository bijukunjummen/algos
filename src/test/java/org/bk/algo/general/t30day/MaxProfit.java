package org.bk.algo.general.t30day;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProfit {
    public int maxProfit(int[] prices) {
        boolean transactionStarted = false;

        int profit = 0;
        int tranPrice = 0;
        int maxIndex = prices.length - 1;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if ((i < maxIndex && i > 0 && prices[i + 1] >= price && prices[i - 1] >= price) || (i != maxIndex && (i == 0) && price <= prices[i + 1])) {
                //localmin
                if (!transactionStarted) {
                    transactionStarted = true;
                    tranPrice = price;
                }
            }

            if ((i < maxIndex && i > 0 && prices[i + 1] <= price && prices[i - 1] <= price) || (i != 0 && i == maxIndex && price >= prices[i - 1])) {
                //local max
                if (transactionStarted) {
                    profit += (price - tranPrice);
                    tranPrice = 0;
                    transactionStarted = false;
                }
            }
        }

        return profit;

    }

    @Test
    void testSamples() {
        assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(7);
    }

    @Test
    void testIncreasing() {
        assertThat(maxProfit(new int[]{1, 2, 3, 4, 5})).isEqualTo(4);
    }

    @Test
    void testSample() {
        assertThat(maxProfit(new int[]{2,2,5})).isEqualTo(3);
    }

    @Test
    void testEmpty() {
        assertThat(maxProfit(new int[]{})).isEqualTo(0);
    }

}