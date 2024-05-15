package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int substringLen = wordLen * len;
        List<Integer> indexes = new ArrayList<>();

        for (int st = 0, e = 0; e < s.length(); e++) {
            if (e - st + 1 > substringLen) {
                st++;
            }
            if (e - st + 1 == substringLen) {
                String sub = s.substring(st, e + 1);
                if (isValid(sub, wordMap, wordLen)) {
                    indexes.add(st);
                }
            }
        }
        return indexes;
    }

    private boolean isValid(String sub, Map<String, Integer> wordMap, int wordLen) {
        Map<String, Integer> foundMap = new HashMap<>();
        for (int s = 0; s < sub.length(); s = s + wordLen) {
            String w = sub.substring(s, s + wordLen);
            if (!wordMap.containsKey(w)) {
                return false;
            }
            if (wordMap.get(w) <= foundMap.getOrDefault(w, 0)) {
                return false;
            }
            foundMap.put(w, foundMap.getOrDefault(w, 0) + 1);
        }
        return true;
    }


    @Test
    void testFindSubstr() {
        assertThat(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"})).isEqualTo(List.of(6, 9, 12));
        assertThat(findSubstring("barfoothefoobarman", new String[]{"bar", "foo"})).isEqualTo(List.of(0, 9));
        assertThat(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"})).isEqualTo(List.of());
    }
}