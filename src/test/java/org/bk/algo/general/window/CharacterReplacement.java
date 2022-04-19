package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterReplacement {
    public static int findLength(String str, int k) {
        int maxCount = 0;
        int maxLength = 0;
        Map<Character, Integer> countsMap = new HashMap<>();
        for (int s = 0, e = 0; e < str.length(); e++) {
            char c = str.charAt(e);
            int currCount = countsMap.getOrDefault(c, 0);
            countsMap.put(c, currCount + 1);
            maxCount = Math.max(maxCount, currCount + 1);
            if (e - s + 1 - maxCount > k) {
                char left = str.charAt(s);
                countsMap.put(left, countsMap.get(left) - 1);
                s++;
            }
            maxLength = Math.max(maxLength, e - s + 1);
        }
        return maxLength;
    }

    @Test
    void testReplacement() {
        assertThat(findLength("aabccbb", 2)).isEqualTo(5);
        assertThat(findLength("abbcb", 1)).isEqualTo(4);
        assertThat(findLength("abccde", 1)).isEqualTo(3);
    }
}
