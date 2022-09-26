package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> patternMap = charFrequencyMap(pattern);
        Map<Character, Integer> currMap = new HashMap<>();
        for (int s = 0, e = 0; e < str.length(); e++) {
            char c = str.charAt(e);
            currMap.put(c, currMap.getOrDefault(c, 0) + 1);
            if (currMap.equals(patternMap)) {
                return true;
            }
            while (currMap.getOrDefault(c, 0) > patternMap.getOrDefault(c, 0)) {
                char atS = str.charAt(s);
                int countAtS = currMap.getOrDefault(atS, 0);
                if (countAtS == 1) {
                    currMap.remove(atS);
                } else {
                    currMap.put(atS, countAtS - 1);
                }
                s++;
            }
        }
        return false;
    }

    private static Map<Character, Integer> charFrequencyMap(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    @Test
    void testPerm() {
        assertThat(findPermutation("oidbcaf", "abc")).isTrue();
        assertThat(findPermutation("odicf", "dc")).isFalse();
        assertThat(findPermutation("bcdxabcdy", "bcdyabcdx")).isTrue();
        assertThat(findPermutation("aaacb", "abc")).isTrue();
    }
}
