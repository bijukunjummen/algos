package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationSubstring {
    public boolean checkInclusion(String s1, String s2) {
        return false;
    }


    @Test
    void test1() {
        assertThat(checkInclusion("ab", "eidbaooo")).isTrue();
    }
}