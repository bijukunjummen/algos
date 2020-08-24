package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SumPerfectSquares {
    public int numSquares(int n) {
        int maxRange = (int) Math.floor(Math.sqrt(n));
        int[] possibleSquares = new int[maxRange];
        int idx = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = maxRange; i > 0; i--) {
            final int sq = i * i;
            possibleSquares[idx++] = sq;
            dp.put(sq, 1);
        }

        return numSquares(n, 0, possibleSquares, dp);
    }

    private int numSquares(int n, int currLength, int[] possibleSquares, Map<Integer, Integer> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        if (n == 0) {
            return currLength;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int sq : possibleSquares) {
            int currMin = numSquares(n - sq, currLength + 1, possibleSquares, dp);
            if (currMin < min) {
                min = currMin;
            }
        }
        dp.put(n, min + 1);
        return min + 1;
    }

    @Test
    void testNumSquares() {
        assertThat(numSquares(13)).isEqualTo(2);
        assertThat(numSquares(12)).isEqualTo(3);
        assertThat(numSquares(7168)).isEqualTo(4);
    }
}