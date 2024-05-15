package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            while (start <= end && !isValidChar(arr[start])) {
                start++;
            }

            while (end >= start && !isValidChar(arr[end])) {
                end--;
            }
            if ((start <= end) && Character.toLowerCase(arr[start]) != Character.toLowerCase(arr[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    private boolean isValidChar(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    @Test
    void test() {
        assertThat(isPalindrome("A man, a plan, a canal: Panama")).isTrue();
        assertThat(isPalindrome("race a car")).isFalse();
        assertThat(isPalindrome(" ")).isTrue();
        assertThat(isPalindrome("a.")).isTrue();
        assertThat(isPalindrome(".,")).isTrue();
    }
}