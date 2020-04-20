package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapOfAnagrams = new HashMap<>();

        for (String s : strs) {
            final String canonical = canonical(s);
            if (!mapOfAnagrams.containsKey(canonical)) {
                mapOfAnagrams.put(canonical, new ArrayList<>());
            }
            mapOfAnagrams.get(canonical).add(s);

        }
        return new ArrayList<>(mapOfAnagrams.values());
    }

    private String canonical(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        return String.valueOf(sArr);
    }

    @Test
    void test1() {
        assertThat(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})).isEqualTo(List.of(List.of("ate", "eat", "tea"), List.of("nat", "tan"), List.of("bat")));
    }

}