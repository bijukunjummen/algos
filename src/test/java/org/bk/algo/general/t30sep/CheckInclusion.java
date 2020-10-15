package org.bk.algo.general.t30sep;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        char[] charsToMatch = s1.toCharArray();
        char[] target = s2.toCharArray();
        
        if (charsToMatch.length > target.length) return false;
        
        Arrays.sort(charsToMatch);
        for (int i = 0; i <= (target.length - charsToMatch.length); i++) {
            if (matches(charsToMatch, target, i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean matches(char[] toMatch, char[] target, int idx) {
        char[] targetAtWindow = new char[toMatch.length];
        for (int i = idx; i <= idx + toMatch.length - 1; i++) {
            targetAtWindow[i - idx] = target[i];
        }
        Arrays.sort(targetAtWindow);
        return Arrays.compare(targetAtWindow, toMatch) == 0;
    }

    @Test
    void testInclusion() {
        assertThat(checkInclusion("ab", "eidbaooo")).isTrue();
    }
}