package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> indexMap = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            Character ch = s.charAt(j);
            if (indexMap.containsKey(ch) && indexMap.get(ch) >= i) {
                ans = Math.max(ans, j - i);
                i = indexMap.get(ch) + 1;
                indexMap.put(ch, j);
            } else {
                ans = Math.max(ans, j - i + 1);
                indexMap.put(ch, j);
            }
        }
        return ans;
    }

    @Test
    void testSamples() {
        System.out.println(0b1 + 0b1 + 0b1);
        assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }
}
