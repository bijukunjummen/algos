package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subset(0, nums, List.of(), result);
        return result;
    }

    private void subset(int idx, int[] nums, List<Integer> history, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(history);
            return;
        }

        int n = nums[idx];
        List<Integer> newHistory = new ArrayList<>(history);
        newHistory.add(n);
        subset(idx + 1, nums, newHistory, result);
        subset(idx + 1, nums, history, result);
    }

    @Test
    void testSubsets() {
        assertThat(subsets(new int[]{1, 2, 3}).stream().collect(Collectors.toSet()))
                .isEqualTo(Set.of(List.of(1, 2, 3), List.of(1, 2), List.of(1, 3), List.of(2, 3),
                        List.of(1), List.of(2), List.of(3), List.of()));
    }
}
