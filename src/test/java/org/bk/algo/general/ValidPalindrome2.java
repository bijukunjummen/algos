package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, new AtomicBoolean(true));
    }

    private boolean validPalindrome(String s, int lo, int hi, AtomicBoolean chances) {
        if (lo >= hi) {
            return true;
        }

        if (s.charAt(lo) == s.charAt(hi)) {
            return validPalindrome(s, lo + 1, hi - 1, chances);
        } else {
            if (chances.get()) {
                chances.set(false);
                return validPalindrome(s, lo + 1, hi, chances) || validPalindrome(s, lo, hi - 1, chances);
            } else {
                return false;
            }
        }
    }

    @Test
    void testValidPalindrome() {
        assertThat(validPalindrome("aba")).isTrue();
        assertThat(validPalindrome("abda")).isTrue();
        assertThat(validPalindrome("abdda")).isTrue();
        assertThat(validPalindrome("eeccccbebaeeabebccceea")).isFalse();
    }
}