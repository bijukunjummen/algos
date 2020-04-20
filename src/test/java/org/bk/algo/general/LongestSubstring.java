package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int i = 0;
        while (i < s.length()) {
            int length = lengthOfLongestSubstring(s, i);
            if (length > maxLen) {
                maxLen = length;
            }
            i ++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s, int fromIndex) {
        Set<Character> alreadySeen = new HashSet<>();
        int maxLen = 0;

        for (int i = fromIndex; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (alreadySeen.contains(ch)) {
                return maxLen;
            } else {
                alreadySeen.add(ch);
                maxLen++;
            }
        }

        return maxLen;
    }

    @Test
    void testSamples() {
        // assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        // assertThat(lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        // assertThat(lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }
}
