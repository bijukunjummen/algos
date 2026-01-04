package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int d = 0;
        int c = 1;

        for (int i = n - 1; i > 0; i--) {
            d = digits[i] + c;
            digits[i] = d % 10;
            c = d / 10;
        }
        if (c == 0) {
            return digits;
        }
        d = digits[0] + c;
        if (d > 9) {
            c = d / 10;
            digits[0] = d % 10;
            int[] newDigits = new int[n + 1];
            newDigits[0] = c;
            for (int i = 0; i < n; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        } else {
            digits[0] = d;
            return digits;
        }
    }


    @Test
    void testPlusOne() {
        assertThat(plusOne(new int[]{1, 2, 3})).isEqualTo(new int[]{1, 2, 4});
        assertThat(plusOne(new int[]{4, 3, 2, 1})).isEqualTo(new int[]{4, 3, 2, 2});
        assertThat(plusOne(new int[]{9})).isEqualTo(new int[]{1, 0});
    }
}