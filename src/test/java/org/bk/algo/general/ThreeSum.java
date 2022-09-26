package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i <= nums.length - 3; i++) {
            threeSum(nums, i, result);
        }

        List<List<Integer>> asList = new ArrayList<>(result);
        return asList;
    }


    private void threeSum(int[] nums, int idx, Set<List<Integer>> result) {
        int first = nums[idx];
        int targetSum = -first;
        Map<Integer, Integer> aggregate = new HashMap<>();
        for (int i = idx + 1; i < nums.length; i++) {
            int num = nums[i];
            int count = aggregate.getOrDefault(num, 0);
            aggregate.put(num, count + 1);

            int toFind = targetSum - num;
            if (aggregate.containsKey(toFind)) {
                if (toFind == num) {
                    if (aggregate.get(num) > 1) {
                        result.add(List.of(first, num, toFind));
                    }
                } else {
                    result.add(List.of(first, num, toFind));
                }
            }
        }
    }

    @Test
    void testThreeSum() {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertThat(result).isEqualTo(List.of(List.of(-1, 2, -1), List.of(-1, 1, 0)));
    }
    @Test
    void testThreeSum2() {
        List<List<Integer>> result = threeSum(new int[]{0, 0, 0});
        assertThat(result).isEqualTo(List.of(List.of(0, 0, 0)));
    }
}
