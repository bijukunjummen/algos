package org.bk.algo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        Integer maxCountNum = null;
        Integer maxCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = numToCount.getOrDefault(num, 0);
            count++;
            numToCount.put(num, count);
            if (count > maxCount) {
                maxCountNum = num;
                maxCount = count;
            }
        }
        return maxCountNum;
    }

    @Test
    void testFindSpecialInteger() {
        Assertions.assertThat(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10})).isEqualTo(6);
    }
}