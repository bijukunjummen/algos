package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class ThreeSet {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> set = new HashMap<>();
        for (int num : nums) {
            set.putIfAbsent(num, 0);
            set.put(num, set.get(num) + 1);
        }
        Set<List<Integer>> consolidated = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> result = findTwoSum(nums, i, set);
            consolidated.addAll(result);
        }
        return consolidated.stream().collect(Collectors.toList());
    }

    private List<List<Integer>> findTwoSum(int[] nums, int idx, Map<Integer, Integer> set) {
        int target = nums[idx] * -1;

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != idx) {
                int c = nums[i];
                if (set.containsKey(target - c)) {
                    if (nums[idx] == c || nums[idx] == (target - c) || (c == target - c)) {
                        int targetCount = ((nums[idx] == c) ? 1 : 0) + ((nums[idx] == (target - c)) ? 1 : 0) + ((c == (target - c)) ? 1 : 0);
                        if (set.get(target - c) == targetCount) {
                            result.add(List.of(nums[idx], c, target - c).stream().sorted().collect(Collectors.toList()));
                        }
                    } else {
                        result.add(List.of(nums[idx], c, target - c).stream().sorted().collect(Collectors.toList()));
                    }
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    @Test
    void testThreeSum() {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }

}