package org.bk.algo.general.t30day;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> set = new LinkedHashMap<>();
        LinkedHashSet<Character> visited = new LinkedHashSet<>();
        char[] chars = s.toCharArray();
        int currIndex = 0;
        for (char c : chars) {
            if (visited.contains(c)) {
                set.remove(c);
            } else {
                set.put(c, currIndex);
                visited.add(c);
            }

            currIndex++;
        }
        return set.size() > 0 ? set.get(set.keySet().iterator().next()) : -1;
    }
}