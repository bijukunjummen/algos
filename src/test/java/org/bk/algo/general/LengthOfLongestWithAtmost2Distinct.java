package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LengthOfLongestWithAtmost2Distinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] cs = s.toCharArray();
        int st = 0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int e = 0; e < cs.length; e++) {
            char c = cs[e];
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > 2) {
                char toRemove = cs[st];
                int removeCount = map.getOrDefault(toRemove, 0);
                if (removeCount == 1) {
                    map.remove(toRemove);
                } else {
                    map.put(toRemove, map.get(toRemove) - 1);
                }
                st++;
            }
            int len = map.values().stream().mapToInt(i -> i).sum();
            longest = Math.max(longest, len);
        }
        return longest;
    }

    @Test
    void test() {
        assertThat(lengthOfLongestSubstringTwoDistinct("eceba")).isEqualTo(3);
        assertThat(lengthOfLongestSubstringTwoDistinct("ccaabbb")).isEqualTo(5);
    }
}
