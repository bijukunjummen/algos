package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeSet {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) return List.of();
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i <= nums.length - 3; i++) {
            threeSum(nums, i, result);
        }
        List<List<Integer>> asList = new ArrayList<>();
        asList.addAll(result);
        return asList;
    }

    private void threeSum(int[] nums, int idx, Set<List<Integer>> result) {
        int first = nums[idx];
        int targetSum = -first;
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int i = idx + 1; i < nums.length; i++) {
            int num = nums[i];
            numToCount.computeIfAbsent(num, n -> 0);
            numToCount.put(num, numToCount.get(num) + 1);
            if (numToCount.containsKey(targetSum - num)) {
                if (targetSum - num == num) {
                    if (numToCount.get(targetSum - num) > 1) {
                        result.add(List.of(first, num, targetSum - num));
                    }
                } else {
                    result.add(List.of(first, num, targetSum - num));
                }
            }
        }
    }

    @Test
    void testThreeSum() {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertThat(result).isEqualTo(List.of(List.of(-1, 2, -1), List.of(-1, 1, 0)));
    }
}