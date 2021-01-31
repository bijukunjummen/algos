package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0;
        int r = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int distinct = 0;
        int largest = 0;
        while (r < s.length()) {
            Character c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            if (count == 0) {
                distinct++;
            }
            windowCounts.put(c, count + 1);
            r++;
            if (distinct <= k) {
                largest = Math.max(largest, r - l);
            }
            while (distinct > k && l < r) {
                Character cl = s.charAt(l);
                int countL = windowCounts.get(cl);
                if (countL == 1) {
                    distinct--;
                    windowCounts.remove(cl);
                } else {
                    windowCounts.put(cl, countL - 1);
                }
                l++;
            }
        }
        return largest;
    }

    @Test
    void testLongestSubstKDistinct() {
        assertThat(lengthOfLongestSubstringKDistinct("eceba", 2)).isEqualTo(3);
        assertThat(lengthOfLongestSubstringKDistinct("aa", 0)).isEqualTo(0);
        assertThat(lengthOfLongestSubstringKDistinct("aa", 1)).isEqualTo(2);
        assertThat(lengthOfLongestSubstringKDistinct("a", 2)).isEqualTo(1);
    }
}