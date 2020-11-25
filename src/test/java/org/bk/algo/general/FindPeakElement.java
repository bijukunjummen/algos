package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int prev = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int next = (i <= nums.length - 2)?nums[i  + 1]: nums[i];
            if (n >= prev && n >= next) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void findPeakElementTest() {
        assertThat(findPeakElement(new int[]{1, 2, 3, 1})).isEqualTo(2);
        assertThat(findPeakElement(new int[]{1,2,1,3,5,6,4})).isIn(1, 5);
    }
}