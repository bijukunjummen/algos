package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsMajorityElement {
    public boolean isMajorityElement(int[] nums, int target) {
        int length = nums.length;
        int targetCount = countOf(nums, target);
        return (targetCount > length / 2);
    }

    private int countOf(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] == target) {
            int i = lo;
            while (i + 1 < nums.length && nums[i + 1] == target) {
                i++;
            }
            return i - lo + 1;
        } else {
            return 0;
        }
    }

    @Test
    void testMajority() {
        assertThat(isMajorityElement(new int[]{1, 2}, 2)).isFalse();
        assertThat(isMajorityElement(new int[]{1, 2}, 3)).isFalse();
    }

}