package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesMoreThan2 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    @Test
    void testRemoveDups() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int count = removeDuplicates(nums);
        assertThat(count).isEqualTo(5);
        assertThat(nums).isEqualTo(new int[]{1, 1, 2, 2, 3, 3});
    }
}