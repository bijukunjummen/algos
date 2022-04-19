package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class NoRepeatSubstring {
    public int findLength(String str) {
        int longest = 0;
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int s = 0, e = 0; e < str.length(); e++) {
            char c = str.charAt(e);
            if (lastIndexMap.containsKey(c)) {
                s = lastIndexMap.get(c) + 1;
            }
            longest = Math.max(longest, e - s + 1);
            lastIndexMap.put(c, e);
        }
        return longest;
    }

    @Test
    void testNoRepeatSubstring() {
        assertThat(findLength("aabccbb")).isEqualTo(3);
        assertThat(findLength("abbbb")).isEqualTo(2);
        assertThat(findLength("abccde")).isEqualTo(3);
        assertThat(findLength("abcadefg")).isEqualTo(7);
    }
}