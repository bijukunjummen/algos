package org.bk.algo.general.arr;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CheckIfPanagram {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'a' + 25) {
                set.add(c);
            }
            if (set.size() == 26) {
                return true;
            }
        }
        return false;
    }

    @Test
    void test1() {
        assertThat(checkIfPangram("TheQuickBrownFoxJumpsOverTheLazyDog")).isTrue();
    }
}
