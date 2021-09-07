package org.bk.algo.chap1;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q01UniqueChars {

    public boolean hasUniqueChars(String s) {
        boolean[] found = new boolean[256];

        for (char c : s.toCharArray()) {
            if (found[c]) {
                return false;
            } else {
                found[c] = true;
            }
        }
        return true;
    }

    @Test
    public void testSample1() {
        assertThat(hasUniqueChars("abcdefg")).isTrue();
        assertThat(hasUniqueChars("abcdefd")).isFalse();
    }
}
