package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivideWithBasicOper {
    private static final int HALF_MAX = Integer.MAX_VALUE >> 1;

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean positive = getSign(dividend, divisor);
        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }

        int quotient = 0;
        while (dividend >= divisor) {
            int value = divisor;
            int times = 0;
            while (value < HALF_MAX && (value << 1) <= dividend) {
                value = value << 1;
                times++;
            }
            quotient += (1 << times);
            dividend -= value;
        }
        return positive ? quotient : -quotient;
    }

    private boolean getSign(int dividend, int divisor) {
        return ((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0));
    }

    @Test
    void divideTest() {
        assertThat(divide(10, 3)).isEqualTo(3);
        assertThat(divide(12, 3)).isEqualTo(4);
        assertThat(divide(12, 4)).isEqualTo(3);
        assertThat(divide(12, 4)).isEqualTo(3);
        assertThat(divide(-2147483648, -1)).isEqualTo(Integer.MAX_VALUE);
        assertThat(divide(2147483647, 1)).isEqualTo(Integer.MAX_VALUE);
    }
}