package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numsToCount = new HashMap<>();

        int occ = 0;
        for (int n : nums) {
            if (numsToCount.containsKey(k - n)) {
                occ++;
                adjust(numsToCount, k - n, -1);
            } else {
                adjust(numsToCount, n, 1);
            }
        }
        return occ;
    }

    private void adjust(Map<Integer, Integer> numsToCount, int key, int by) {
        int count = numsToCount.getOrDefault(key, 0);
        int result = count + by;
        if (result == 0) {
            numsToCount.remove(key);
        } else {
            numsToCount.put(key, result);
        }
    }

    @Test
    void testMaxOperations() {
        assertThat(maxOperations(new int[]{1, 2, 3, 4}, 5)).isEqualTo(2);
    }
}