package org.bk.algo.general.t30sep;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
            if (distinct <= k) {
                if (r - l + 1 > largest) {
                    largest = r - l + 1;
                }
            }

            while (distinct > k && l <= r) {
                Character cl = s.charAt(l);
                int countL = windowCounts.get(cl);
                if (countL - 1 == 0) {
                    distinct--;
                }
                windowCounts.put(cl, countL - 1);
                l++;
            }
            r++;
        }
        return largest;
    }


    @Test
    void test() {
        Assertions.assertThat(lengthOfLongestSubstringKDistinct("eceba", 2)).isEqualTo(3);
        Assertions.assertThat(lengthOfLongestSubstringKDistinct("aa", 0)).isEqualTo(0);
        Assertions.assertThat(lengthOfLongestSubstringKDistinct("aa", 1)).isEqualTo(2);
        Assertions.assertThat(lengthOfLongestSubstringKDistinct("a", 2)).isEqualTo(1);
    }
}