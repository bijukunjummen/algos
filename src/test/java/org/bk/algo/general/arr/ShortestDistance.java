package org.bk.algo.general.arr;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, Integer> indexMap = new HashMap<>();
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            indexMap.put(word, i);
            int newDistance = checkDistanceWithOther(indexMap, word, word1, word2);
            distance = Math.min(distance, newDistance);
        }

        return distance;
    }

    private int checkDistanceWithOther(Map<String, Integer> indexMap, String word, String word1, String word2) {
        if (!(word.equals(word1) || word.equals(word2))) {
            return Integer.MAX_VALUE;
        }
        if (word.equals(word1)) {
            if (!indexMap.containsKey(word2)) {
                return Integer.MAX_VALUE;
            }
            return indexMap.get(word1) - indexMap.get(word2);
        }
        if (word.equals(word2)) {
            if (!indexMap.containsKey(word1)) {
                return Integer.MAX_VALUE;
            }
            return indexMap.get(word2) - indexMap.get(word1);
        }

        return Integer.MAX_VALUE;
    }
    //
    @Test
    void testDistance() {
        assertThat(shortestDistance(
                new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"},
                "fox",
                "dog")).isEqualTo(5);
    }

}    
