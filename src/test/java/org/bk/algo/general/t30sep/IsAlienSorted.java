package org.bk.algo.general.t30sep;

import java.util.HashMap;
import java.util.Map;

class IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }
        char[] chars = order.toCharArray();
        Map<Character, Integer> charMap = charPosition(chars);

        String prev = words[0];
        String current = null;

        for (int i = 1; i < words.length; i++) {
            current = words[i];
            if (!isBefore(prev, current, charMap)) {
                return false;
            }
            prev = current;
        }

        return true;
    }

    private boolean isBefore(String before, String current, Map<Character, Integer> charMap) {
        char[] str1 = before.toCharArray();
        char[] str2 = current.toCharArray();

        for (int i = 0; i < Math.min(str1.length, str2.length); i++) {
            if (charMap.get(str1[i]) < charMap.get(str2[i])) {
                return true;
            } else if (charMap.get(str1[i]) > charMap.get(str2[i])) {
                return false;
            }
        }

        return (str1.length <= str2.length);
    }

    private Map<Character, Integer> charPosition(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            map.put(c, i);
        }
        return map;
    }
}