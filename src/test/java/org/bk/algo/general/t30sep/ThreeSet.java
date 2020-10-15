package org.bk.algo.general.t30sep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class ThreeSet {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] > 0) return results.stream().collect(Collectors.toList());

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        results.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return results.stream().collect(Collectors.toList());
    }

}