package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsHappy {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 10) {
            return false;
        }
        int sum = sumOfDigits(n);
        if ( sum == 1) {
            return true;
        } else {
            return isHappy(sum);
        }
    }

    private int sumOfDigits(Integer n) {
        String s = n.toString();
        char[] cArr = s.toCharArray();
        int[] digits = new int[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            digits[i] = cArr[i] - '0';
        }
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i] * digits[i];
        }
        return sum;
    }

    @Test
    void isHappyTest() {
        assertThat(isHappy(7)).isFalse();
    }
}