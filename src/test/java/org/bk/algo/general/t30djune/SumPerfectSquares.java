package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumPerfectSquares {
    public int numSquares(int n) {
        int maxRange = (int) Math.floor(Math.sqrt(n));
        int[] possibleSquares = new int[maxRange];
        int idx = 0;
        for (int i = maxRange; i > 0; i--) {
            possibleSquares[idx++] = i * i;
        }

        return numSquares(n, 0, possibleSquares, 0);
    }

    private int numSquares(int n, int currPos, int[] possibleSquares, int minLength) {

        if (n < 0) {
            return Integer.MAX_VALUE;
        } else if (n == 0) {
            return minLength;
        }
        if (currPos >= possibleSquares.length) {
            return Integer.MAX_VALUE;
        }
        int h = possibleSquares[currPos];
        int t = currPos + 1;

        int len1 = numSquares(n - h, currPos, possibleSquares, minLength + 1);
        int len2 = numSquares(n, t, possibleSquares, minLength);
        if (len1 <= len2) {
            return len1;
        } else {
            return len2;
        }
    }

    @Test
    void testNumSquares() {
        assertThat(numSquares(13)).isEqualTo(2);
        assertThat(numSquares(12)).isEqualTo(3);
    }
}