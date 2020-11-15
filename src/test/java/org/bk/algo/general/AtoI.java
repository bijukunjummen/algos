package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AtoI {
    public int myAtoi(String s) {
        char[] chs = s.toCharArray();
        boolean leadingPosition = true;
        boolean positive = true;
        int num = 0;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (leadingPosition) {
                if (isIgnoredLeading(ch) || (ch <= '9' && ch >= '0')) {
                   if (ch == '-') {
                       positive = false;
                   }
                } else {
                    return 0;
                }
            }

            if (Character.isDigit(ch)) {
                leadingPosition = false;
                int value = ch - '0';
                num = num * 10 + value;
            }
        }
        return positive ? num : -1 * num;
    }

    private boolean isIgnoredLeading(char ch) {
        return ch == ' ' || ch == '-';
    }

    @Test
    void testAtoi() {
        assertThat(myAtoi("123")).isEqualTo(123);
        assertThat(myAtoi("-123")).isEqualTo(-123);
        assertThat(myAtoi(" -123")).isEqualTo(-123);
        assertThat(myAtoi(" a-123")).isEqualTo(0);
    }
}