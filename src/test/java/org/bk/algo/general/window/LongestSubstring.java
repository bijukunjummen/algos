package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;

        Map<Character, Integer> freq = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            int count = freq.getOrDefault(c, 0);
            freq.put(c, count + 1);
            r++;

            while (freq.get(c) > 1) {
                char cl = s.charAt(l);
                int countL = freq.getOrDefault(cl, 0);
                if (countL == 1) {
                    freq.remove(cl);
                } else {
                    freq.put(cl, countL - 1);
                }
                l++;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    public int lengthOfLongestSubstringOptimized(String s) {
        int l = 0;
        int r = 0;
        int max = 0;

        Map<Character, Integer> charToIndex = new HashMap<>();
        while (r < s.length()) {
            Character c = s.charAt(r);
            if (charToIndex.containsKey(c) && charToIndex.get(c) >= l) {
                l = charToIndex.get(c) + 1;
            } else {
                max = Math.max(max, r - l + 1);
            }
            charToIndex.put(c, r);
            r++;
        }
        return max;
    }


    @Test
    void testSamples() {
        assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("dvdf")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("abba")).isEqualTo(2);
        assertThat(lengthOfLongestSubstring("tmmzuxt")).isEqualTo(5);
    }

    @Test
    void testOptimized() {
        assertThat(lengthOfLongestSubstringOptimized("abcabcbb")).isEqualTo(3);
        assertThat(lengthOfLongestSubstringOptimized("bbbbb")).isEqualTo(1);
        assertThat(lengthOfLongestSubstringOptimized("pwwkew")).isEqualTo(3);
        assertThat(lengthOfLongestSubstringOptimized("dvdf")).isEqualTo(3);
        assertThat(lengthOfLongestSubstringOptimized("abba")).isEqualTo(2);
        assertThat(lengthOfLongestSubstringOptimized("tmmzuxt")).isEqualTo(5);
    }
}
