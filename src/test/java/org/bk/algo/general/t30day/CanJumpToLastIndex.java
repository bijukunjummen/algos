package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.assertj.core.api.Assertions.assertThat;

class CanJumpToLastIndex {
    public boolean canJump(int[] nums) {
        BitSet bitSet = new BitSet();
        return dfs(nums, 0, nums.length - 1, bitSet);
    }


    public boolean dfs(int[] nums, int index, int target, BitSet visited) {
        if (visited.get(index)) {
            return false;
        }
        visited.set(index);

        if (index == target) {
            return true;
        }

        int maxJump = nums[index];
        boolean result = false;
        int jumpCountsMax = Math.min(index + maxJump, nums.length - 1) - index;

        for (int i = 0; i < jumpCountsMax; i++) {
            int nextIndex = index + i + 1;
            if (!visited.get(nextIndex)) {
                result = result || dfs(nums, nextIndex, target, visited);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    void canJumpTest() {
        assertThat(canJump(new int[]{2, 3, 1, 1, 4})).isEqualTo(true);
        assertThat(canJump(new int[]{3, 2, 1, 0, 4})).isEqualTo(false);
    }
}