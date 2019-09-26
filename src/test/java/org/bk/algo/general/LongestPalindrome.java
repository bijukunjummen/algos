package org.bk.algo.general;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();

        for (int win = len; win >= 1; win--) {
            String p = tryPalindrome(s, win);
            if (p != null) {
                return p;
            }
        }
        return null;
    }

    public String tryPalindrome(String s, int win) {
        int len = s.length();
        for (int i = 0; i <= len - win; i++) {
            final String substring = s.substring(i, i + win);
            if (isPalindrome(substring)) {
                return substring;
            }
        }
        return null;
    }

    public boolean isPalindrome(String s) {
        final int lastIndex = s.length() - 1;
        int mid = lastIndex / 2;

        for (int i = 0; i <= mid; i++) {
            char left = s.charAt(i);
            char right = s.charAt(lastIndex - i);
            if (!(left == right)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSomeStrings() {
        assertThat(longestPalindrome("dfaadjflakfdjalkfjdkljkldfjklajfdklajdkmanymoremalayalammoreofit")).isEqualTo("malayalam");
        assertThat(longestPalindrome("abaab")).isEqualTo("baab");
    }

    @Test
    public void testPalindrome() {
        assertThat(isPalindrome("malayalam")).isTrue();
        assertThat(isPalindrome("malayala")).isFalse();
        assertThat(isPalindrome("ala")).isTrue();
        assertThat(isPalindrome("a")).isTrue();
        assertThat(isPalindrome("bb")).isTrue();
        assertThat(isPalindrome("bab")).isTrue();
    }
}
