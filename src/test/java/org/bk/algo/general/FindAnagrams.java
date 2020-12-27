package org.bk.algo.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        char[] pArr = p.toCharArray();
        int np = pArr.length;
        char[] sArr = s.toCharArray();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : pArr) {
            int count = pMap.getOrDefault(c, 0);
            pMap.put(c, count + 1);
        }

        List<Integer> output = new ArrayList<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];
            int count = sMap.getOrDefault(c, 0);
            sMap.put(c, count + 1);

            if (i >= pArr.length) {
                char ch = sArr[i - np];
                if (sMap.get(ch) == 1) {
                    sMap.remove(ch);
                } else {
                    sMap.put(ch, sMap.get(ch) - 1);
                }
            }

            if (sMap.equals(pMap)) {
                output.add(i - np + 1);
            }

        }
        return output;
    }
}
