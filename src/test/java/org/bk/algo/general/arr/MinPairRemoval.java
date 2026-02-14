package org.bk.algo.general.arr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MinPairRemoval {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n: nums) {
            list.add(n);
        }

        int count = 0;
        while (!isSorted(list)) {
            removeMaxSum(list);
            count++;
        }
        return count;
    }

    private void removeMaxSum(List<Integer> list) {
        int n = list.size();

        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            sumList.add(list.get(i) + list.get(i + 1));
        }
        int minIndex = -1;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0 ; i < sumList.size(); i++) {
            if (sumList.get(i) < minSum) {
                minSum = sumList.get(i);
                minIndex = i;
            }
        }
        list.remove(minIndex);
        list.remove(minIndex);
        list.add(minIndex, minSum);
    }

    private boolean isSorted(List<Integer> nums) {
        if (nums.isEmpty()) {
            return true;
        }
        int n = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num < n) {
                return false;
            }
            n = num;
        }
        return true;
    }

    @Test
    void testRemoveMax() {
        assertThat(minimumPairRemoval(new int[]{5, 2, 3, 1})).isEqualTo(2);
    }
}