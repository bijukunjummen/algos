package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumDecodings {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        Integer[] memo = new Integer[s.length()];
        return numDecodings(0, arr, memo);
    }

    private int numDecodings(int idx, char[] arr, Integer[] memo) {
        if (idx >= arr.length) {
            return 1;
        }
        int count = 0;
        if (memo[idx] != null) {
            return memo[idx];
        }
        char ch1 = arr[idx];

        if (isValid(ch1)) {
            count += numDecodings(idx + 1, arr, memo);
        }

        if (idx + 1 <= arr.length - 1) {
            char ch2 = arr[idx + 1];
            if (isValid(ch1, ch2)) {
                count += numDecodings(idx + 2, arr, memo);
            }
        }

        memo[idx] = count;
        return count;
    }

    boolean isValid(char ch1) {
        return ch1 > '0' && ch1 <= '9';
    }

    boolean isValid(char ch1, char ch2) {
        int n = (ch1 - '0') * 10 + (ch2 - '0');
        return n >= 10 && n <= 26;
    }

    @Test
    void testDecodings() {
        assertThat(numDecodings("2611055971756562")).isEqualTo(4);
        assertThat(numDecodings("111111111111111111111111111111111111111111111")).isEqualTo(1836311903);
    }
}