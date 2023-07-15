package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String str, int k) {
        Map<Character, Integer> countsMap = new HashMap<>();
        int maxChars = 0;
        int s = 0;
        for (int e = 0; e < str.length(); e++) {
            Character c = str.charAt(e);
            int currentCount = countsMap.getOrDefault(c, 0);
            countsMap.put(c, currentCount + 1);
            while (countsMap.size() > k) {
                char toRemove = str.charAt(s);
                int count = countsMap.get(toRemove);
                if (count == 1) {
                    countsMap.remove(toRemove);
                } else {
                    countsMap.put(toRemove, count - 1);
                }
                s++;
            }
            maxChars = Math.max((e - s + 1), maxChars);
        }
        return maxChars;
    }

    @Test
    void test() {
        assertThat(lengthOfLongestSubstringKDistinct("araaci", 2)).isEqualTo(4);
        assertThat(lengthOfLongestSubstringKDistinct("araaci", 1)).isEqualTo(2);
        assertThat(lengthOfLongestSubstringKDistinct("cbbebi", 3)).isEqualTo(5);
        assertThat(lengthOfLongestSubstringKDistinct("cbbebi", 10)).isEqualTo(6);
        assertThat(lengthOfLongestSubstringKDistinct("eceba", 2)).isEqualTo(3);
        assertThat(lengthOfLongestSubstringKDistinct("aa", 0)).isEqualTo(0);
        assertThat(lengthOfLongestSubstringKDistinct("aa", 1)).isEqualTo(2);
        assertThat(lengthOfLongestSubstringKDistinct("a", 2)).isEqualTo(1);
    }
}