package org.bk.algo.general.arr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int p1 = 0, p2 = nums.length - 1;

        while (p1 < p2) {
            while (nums[p2] == val && p2 > 0) {
                p2--;
            }
            if (p1 >= p2) {
                break;
            }
            if (nums[p1] == val) {
                swap(nums, p1, p2);
            }
            p1++;
        }
        return (nums[p1] == val)? p1:p1 + 1;
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    @Test
    void testRemoveElement() {
        int[] nums = new int[]{3, 2, 2, 3};
        int result = removeElement(nums, 3);
        assertThat(result).isEqualTo(2);
        assertThat(nums).isEqualTo(new int[]{2, 2, 3, 3});
    }

    @Test
    void testRemove2() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int result = removeElement(nums, 2);
        assertThat(result).isEqualTo(5);
        assertThat(nums).isEqualTo(new int[]{0, 1, 4, 0, 3, 2, 2, 2});

    }
}