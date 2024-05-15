package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

class CanJumpToLastIndex {
    public boolean canJump(int[] nums) {
        BitSet bitSet = new BitSet();
        AtomicBoolean found = new AtomicBoolean(false);
        return canJump(nums, 0, bitSet, found);
    }


    public boolean canJump(int[] nums, int index, BitSet visited, AtomicBoolean found) {
        if (visited.get(index)) {
            return false;
        }
        visited.set(index);
        if (found.get()) {
            return true;
        }

        if (index == nums.length - 1) {
            found.set(true);
            return true;
        }

        int maxJump = nums[index];
        int jumpCountsMax = Math.min(index + maxJump, nums.length - 1) - index;

        for (int i = 0; i < jumpCountsMax; i++) {
            int nextIndex = index + i + 1;
            if (!visited.get(nextIndex)) {
                if (found.get() || canJump(nums, nextIndex, visited, found)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    void canJumpTest() {
        assertThat(canJump(new int[]{2, 3, 1, 1, 4})).isEqualTo(true);
//        assertThat(canJump(new int[]{3, 2, 1, 0, 4})).isEqualTo(false);
    }
}