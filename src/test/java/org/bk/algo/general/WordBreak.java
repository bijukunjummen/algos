package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] validWordBreak = new Boolean[s.length()];
        return wordBreak(s, new HashSet<>(wordDict), 0, validWordBreak);
    }

    private boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] validWordBreak) {
        if (start == s.length()) {
            return true;
        }
        if (validWordBreak[start] != null) {
            return validWordBreak[start];
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (wordDict.contains(sub)) {
                if (wordBreak(s, wordDict, i, validWordBreak)) {
                    validWordBreak[start] = true;
                    return true;
                }
            }
        }
        validWordBreak[start] = false;
        return false;
    }

    @Test
    void wordBreakTest() {
//        "applepenapple", wordDict = ["apple", "pen"]
        assertThat(wordBreak("applepenapple", List.of("apple", "pen"))).isTrue();
    }

    @Test
    void wordBreakTest2() {
        assertThat(wordBreak("aaaaaaa", List.of("aaaa", "aaa"))).isTrue();
    }

}
