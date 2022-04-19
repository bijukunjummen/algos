package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MaxFruitCountOf2Types {
    public int maxFruit(char[] arr) {
        int maxFruit = 0;
        Map<Character, Integer> buckets = new HashMap<>();
        for (int s = 0, e = 0; e < arr.length; e++) {
            Character c = arr[e];
            buckets.put(c, buckets.getOrDefault(c, 0) + 1);
            while (buckets.size() > 2) {
                char fruitType = arr[s];
                s++;
                if (buckets.containsKey(fruitType)) {
                    int sCount = buckets.getOrDefault(fruitType, 0);
                    if (sCount == 1) {
                        buckets.remove(fruitType);
                    } else {
                        buckets.put(fruitType, sCount - 1);
                    }
                }
            }
            maxFruit = Math.max(maxFruit, e - s + 1);
        }

        return maxFruit;
    }

    @Test
    void testMaxFruit() {
        assertThat(maxFruit(new char[]{'A', 'B', 'C', 'A', 'C'})).isEqualTo(3);
        assertThat(maxFruit(new char[]{'A', 'B', 'C', 'B', 'B', 'C'})).isEqualTo(5);
    }
}