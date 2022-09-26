package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringNoRepeating {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charInWindow = new HashMap<>();
        char[] chars = s.toCharArray();
        int maxDistinct = 0;
        for (int st = 0, e = 0; e < chars.length; e++) {
            char c = chars[e];
            putInMap(c, charInWindow);
            while (charInWindow.get(c) > 1) {
                char startChar = chars[st];
                decrementInMap(startChar, charInWindow);
                st++;
            }
            maxDistinct = Math.max(maxDistinct, e - st + 1);
        }

        return maxDistinct;
    }

    private void decrementInMap(char startChar, Map<Character, Integer> charInWindow) {
        if (charInWindow.containsKey(startChar)) {
            int count = charInWindow.get(startChar);
            if (count > 1) {
                charInWindow.put(startChar, count - 1);
            } else {
                charInWindow.remove(startChar);
            }
        }
    }

    private void putInMap(char c, Map<Character, Integer> charInWindow) {
        charInWindow.put(c, charInWindow.getOrDefault(c, 0) + 1);
    }

    @Test
    void test() {
        assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }
}
