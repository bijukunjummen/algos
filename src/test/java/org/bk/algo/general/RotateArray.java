package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i  + k) % nums.length;
            tmp[newIndex] = nums[i];
        }
        System.arraycopy(tmp, 0, nums, 0, nums.length);
    }

    @Test
    void testRotate() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        assertThat(nums).isEqualTo(new int[]{5, 6, 7, 1, 2, 3, 4});
    }
}