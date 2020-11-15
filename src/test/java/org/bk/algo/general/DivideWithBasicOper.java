package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivideWithBasicOper {
    public int divide(int dividend, int divisor) {
        boolean positive = sign(dividend, divisor);

        int absResult = subtractUntilLess(abs(dividend), abs(divisor));

        if (positive) {
            return absResult;
        } else {
            if (isOneLess(dividend)) {
                return (0 - absResult) - 1;
            } else {
                return (0 - absResult);
            }
        }
    }

    private boolean sign(int dividend, int divisor) {
        if ((dividend < 0 && divisor < 0) || (dividend >= 0 && divisor >= 0)) {
            return true;
        }
        return false;
    }

    private int abs(int n) {
        if (n < 0) {
            if (n != Integer.MIN_VALUE) {
                return 0 - n;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return n;
    }

    private boolean isOneLess(int n) {
        if (n == Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    private int subtractUntilLess(int dividend, int divisor) {
        int divd = dividend;
        int divs = divisor;
        int doubledBy = 0;
        while (divd > (divs << 1) && (divs < (divs << 1))) {
            divs = divs << 1;//double the divisor
            doubledBy++;
        }

        int count = 0;
        while (divd > divs) {
            divd = divd - divs;
            count++;
        }

        int part1 = count << doubledBy;

        count = 0;
        while (divd >= divisor) {
            divd = divd - divisor;
            count++;
        }
        return part1 + count;
    }

    @Test
    void divideTest() {
        assertThat(divide(10, 3)).isEqualTo(3);
        assertThat(divide(12, 3)).isEqualTo(4);
        assertThat(divide(12, 4)).isEqualTo(3);
        assertThat(divide(12, 4)).isEqualTo(3);
        assertThat(divide(-2147483648, -1)).isEqualTo(Integer.MAX_VALUE);
    }
}