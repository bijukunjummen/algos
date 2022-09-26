package org.bk.algo.general.window;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> freqMap = createFreqMap(pattern);
        Map<Character, Integer> strMap = new HashMap<>();
        for (int s = 0, e = 0; e < str.length(); e++) {
            char atE = str.charAt(e);
            strMap.put(atE, strMap.getOrDefault(atE, 0) + 1);

            while (strMap.getOrDefault(atE, 0) > freqMap.getOrDefault(atE, 0)) {
                char atS = str.charAt(s);

                Integer countAtS = strMap.getOrDefault(atS, 0);
                if (countAtS == 1) {
                    strMap.remove(atS);
                } else {
                    strMap.put(atS, countAtS - 1);
                }
                s++;
            }
            if (strMap.equals(freqMap)) {
                resultIndices.add(s);
            }
        }
        return resultIndices;
    }

    private static Map<Character, Integer> createFreqMap(String pattern) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character c : pattern.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        return charMap;
    }

    @Test
    void testAnagrams() {
        assertThat(findStringAnagrams("ppqp", "pq")).isEqualTo(List.of(1, 2));
        assertThat(findStringAnagrams("abbcabc", "abc")).isEqualTo(List.of(2, 3, 4));
    }
}
