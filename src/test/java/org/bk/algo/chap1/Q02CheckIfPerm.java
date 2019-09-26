package org.bk.algo.chap1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class Q02CheckIfPerm {

    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        if (Arrays.equals(s1Arr, s2Arr)) {
            return true;
        }
        return false;
    }

    @Test
    public void testIsPerm() {
        assertThat(isPermutation("abc", "bac")).isTrue();
    }
}
