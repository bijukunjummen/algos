package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextPermutation {
    public void nextPermutation(int[] nums) {
        int r = nums.length - 2;
        while (r >= 0 && nums[r] >= nums[r + 1]) {
            r--;
        }
        // r is at a place where value is less than one after
        if (r >= 0) {
            int swapWith = nums.length - 1;
            while (swapWith > r && nums[swapWith] <= nums[r]) {
                swapWith--;
            }
            swap(nums, r, swapWith);
        }
        reverse(nums, r + 1);
    }

    private void reverse(int[] nums, int idx) {
        int l = idx;
        int r = nums.length - 1;

        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    @Test
    void testPerm() {
        int[] arr1 = new int[]{1, 2, 3};
        nextPermutation(arr1);
        assertThat(arr1).isEqualTo(new int[]{1, 3, 2});

        int[] arr2 = new int[]{3, 2, 1};
        nextPermutation(arr2);
        assertThat(arr2).isEqualTo(new int[]{1, 2, 3});

        int[] arr3 = new int[]{1, 5, 1};
        nextPermutation(arr3);
        assertThat(arr3).isEqualTo(new int[]{5, 1, 1});

        int[] arr4 = new int[]{5, 1, 1};
        nextPermutation(arr4);
        assertThat(arr4).isEqualTo(new int[]{1, 1, 5});
    }
}