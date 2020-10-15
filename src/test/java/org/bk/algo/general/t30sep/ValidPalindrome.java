package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPalindrome {
    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int mid = len / 2;
        int b = 0;
        int e = len - 1;

        Result isRootValid = followReturn(cs, b, e);
        if (isRootValid.valid) {
            return true;
        }

        Result isValidLeft = followReturn(cs, isRootValid.b + 1, isRootValid.e);
        if (isValidLeft.valid) return true;
        Result isValidRight = followReturn(cs, isRootValid.b, isRootValid.e - 1);
        return isValidRight.valid;
    }

    private Result followReturn(char[] cs, int b, int e) {
        while (b <= e) {
            if (cs[b] != cs[e]) {
                return new Result(false, b, e);
            }
            b++;
            e--;
        }
        return new Result(true, b, e);
    }


    static class Result {
        private boolean valid;
        private int b;
        private int e;

        public Result(boolean valid, int b, int e) {
            this.valid = valid;
            this.b = b;
            this.e = e;
        }
    }

    @Test
    void testPal() {
        // assertThat(validPalindrome("aba")).isTrue();
        // assertThat(validPalindrome("abba")).isTrue();
        assertThat(validPalindrome("adbba")).isTrue();
    }
}