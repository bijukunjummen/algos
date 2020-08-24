package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindrome {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : chars) {
            if (!freqMap.containsKey(c)) {
                freqMap.put(c, 0);
            }
            int currCount = freqMap.get(c);
            freqMap.put(c, ++currCount);
        }
        int initialLength = chars.length;

        long numberOfOdd = freqMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 == 1)
                .count();

        if (numberOfOdd <= 1L) {
            return initialLength;
        } else {
            return (int) (initialLength - (numberOfOdd - 1));
        }
    }

    @Test
    void testLongestPalindrome() {
        assertThat(longestPalindrome("bb")).isEqualTo(2);
    }
}