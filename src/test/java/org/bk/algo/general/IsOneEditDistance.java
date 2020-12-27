package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        String first = s;
        String second = t;
        int diff = Math.abs(s.length() - t.length());
        if (diff > 1) {
            return false;
        }
        boolean replaced = true;
        if (diff == 1) {
            replaced = false;
        }

        if (s.length() < t.length()) {
            first = t;
            second = s;
        }

        int nedits = 0;
        int p = 0;
        int q = 0;

        while (p < first.length() && q < second.length()) {
            if (first.charAt(p) == second.charAt(q)) {
                p++;
                q++;
            } else {
                if (replaced) {
                    p++;
                    q++;
                } else {
                    p++;
                }
                nedits++;
            }
            if (nedits > 1) {
                return false;
            }
        }
        nedits += first.length()  - p;
        return nedits == 1;
    }

    @Test
    void testOneEdit() {
        assertThat(isOneEditDistance("ab", "acb")).isTrue();
        assertThat(isOneEditDistance("abc", "ab")).isTrue();
        assertThat(isOneEditDistance("a", "")).isTrue();
        assertThat(isOneEditDistance("a", "")).isTrue();
    }
}