package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class FruitsInBaskets {
    public int totalFruit(int[] fruits) {
        int s = 0;
        int currentMaxDistinct = 0;
        Map<Integer, Integer> fruitTypeToCountMap = new HashMap<>();
        for (int e = 0; e < fruits.length; e++) {
            int fruitType = fruits[e];
            int count = fruitTypeToCountMap.getOrDefault(fruitType, 0);
            fruitTypeToCountMap.put(fruitType, count + 1);

            while (fruitTypeToCountMap.size() > 2) {
                int toRemove = fruits[s];
                int c = fruitTypeToCountMap.get(toRemove);
                if (c > 1) {
                    fruitTypeToCountMap.put(toRemove, c - 1);
                } else {
                    fruitTypeToCountMap.remove(toRemove);
                }
                s++;
            }
            currentMaxDistinct = Math.max(currentMaxDistinct, fruitTypeToCountMap.values().stream().mapToInt(i -> i).sum());

        }
        return currentMaxDistinct;
    }

    @Test
    void test() {
        assertThat(totalFruit(new int[]{1, 2, 1})).isEqualTo(3);
        assertThat(totalFruit(new int[]{0, 1, 2, 2})).isEqualTo(3);
        assertThat(totalFruit(new int[]{1, 2, 3, 2, 2})).isEqualTo(4);
    }
}
