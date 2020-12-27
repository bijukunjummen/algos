package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProfit2Transactions {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int leftMin = prices[0];
        int rightMax = prices[length - 1];


        int[] leftProfits = new int[length];
        int[] rightProfits = new int[length + 1];

        for (int l = 1; l < length; l++) {
            leftProfits[l] = Math.max(leftProfits[l - 1], prices[l] - leftMin);
            leftMin = Math.min(leftMin, prices[l]);

            int r = length - 1 - l;
            rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }

        int maxProfit = 0;
        for (int i = 0; i < length; ++i) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
        }
        return maxProfit;
    }

    @Test
    void testSamples() {
        assertThat(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})).isEqualTo(6);
    }

    @Test
    void testEmpty() {
        assertThat(maxProfit(new int[]{})).isEqualTo(0);
    }

}