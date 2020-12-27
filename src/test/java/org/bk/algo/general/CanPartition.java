package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CanPartition {
    public boolean canPartition(int[] nums) {
        Map<Integer, Map<Integer, Boolean>> memo = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return canPartition(0, nums, target, target, memo);
    }

    private boolean canPartition(int idx, int[] nums, int subsetSum, int target, Map<Integer, Map<Integer, Boolean>> memo) {
        if (subsetSum == 0) {
            return true;
        }
        if (idx == nums.length || subsetSum < 0) {
            return false;
        }
        if (memo.containsKey(idx) && memo.get(idx).containsKey(subsetSum)) {
            return memo.get(idx).get(subsetSum);
        }
        boolean result = canPartition(idx + 1, nums, subsetSum, target, memo) || canPartition(idx + 1, nums, subsetSum - nums[idx], target, memo);
        memo.computeIfAbsent(idx, k -> new HashMap<>());
        memo.get(idx).putIfAbsent(subsetSum, result);
        return result;
    }

    @Test
    void testPartition() {
        assertThat(canPartition(new int[]{1, 5, 11, 5})).isTrue();
    }
}