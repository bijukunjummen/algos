package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pFreq = new HashMap<>();
        for (char c : p.toCharArray()) {
            int count = pFreq.getOrDefault(c, 0);
            pFreq.put(c, count + 1);
        }

        int l = 0, r = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        while (r < s.length()) {
            int count = sMap.getOrDefault(s.charAt(r), 0);
            sMap.put(s.charAt(r), count + 1);
            r++;
            if (r - l == p.length()) {
                if (sMap.equals(pFreq)) {
                    result.add(l);
                }
                char lChar = s.charAt(l);
                int lCount = sMap.get(lChar);
                if (lCount == 1) {
                    sMap.remove(lChar);
                } else {
                    sMap.put(lChar, lCount - 1);
                }
                l++;
            }
        }
        return result;
    }

    @Test
    void testfind() {
        assertThat(findAnagrams("cbaebabacd", "abc")).isEqualTo(List.of(0, 6));
    }
}
