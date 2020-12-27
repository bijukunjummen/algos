package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AtoI {
    public int myAtoi(String s) {
        boolean positive = true;
        char[] arr = s.toCharArray();
        int result = 0;
        int idx = 0;
        while (idx < arr.length && arr[idx] == ' ') {
            idx++;
        }
        if (idx >= arr.length) return 0;
        if (arr[idx] == '+') {
            positive = true;
            idx++;
        } else if (arr[idx] == '-') {
            positive = false;
            idx++;
        } else if (Character.isDigit(arr[idx])) {
            positive = true;
        }
        while (idx < arr.length && arr[idx] >= '0' && arr[idx] <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (arr[idx] - '0') > 7)) {
                if (positive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + (arr[idx] - '0');
            idx++;
        }
        return positive ? result : (-1 * result);
    }

    @Test
    void testAtoi() {
        assertThat(myAtoi("123")).isEqualTo(123);
        assertThat(myAtoi("-123")).isEqualTo(-123);
        assertThat(myAtoi(" -123")).isEqualTo(-123);
        assertThat(myAtoi(" -123 some words")).isEqualTo(-123);
        assertThat(myAtoi(" a-123")).isEqualTo(0);
        assertThat(myAtoi("")).isEqualTo(0);

    }
}