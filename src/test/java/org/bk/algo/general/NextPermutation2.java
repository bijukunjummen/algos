package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextPermutation2 {
    public void nextPermutation(int[] nums) {
        int[] swapPoints = potentialSwapPoint(nums);
        if (swapPoints.length == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        swap(nums, swapPoints[0], swapPoints[1]);
        reverse(nums, swapPoints[0] + 1, nums.length - 1);

    }

    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    private int[] potentialSwapPoint(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int swapWithIndex = toSwapWith(nums, i);
            if (swapWithIndex != -1) {
                return new int[]{i, swapWithIndex};       
            }
        }
        return new int[]{};
    }

    private int toSwapWith(int[] nums, int idx) {
        int n = nums[idx];
        for (int i = nums.length - 1; i > idx; i--) {
            if (n < nums[i]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void testPerm() {
        int[] arr1 = new int[]{1, 2, 3};
        nextPermutation(arr1);
        assertThat(arr1).isEqualTo(new int[]{1, 3, 2});

        int[] arr5 = new int[]{1, 3, 2};
        nextPermutation(arr5);
        assertThat(arr5).isEqualTo(new int[]{2, 1, 3});

        int[] arr2 = new int[]{3, 2, 1};
        nextPermutation(arr2);
        assertThat(arr2).isEqualTo(new int[]{1, 2, 3});

        int[] arr3 = new int[]{1, 5, 1};
        nextPermutation(arr3);
        assertThat(arr3).isEqualTo(new int[]{5, 1, 1});

        int[] arr4 = new int[]{5, 1, 1};
        nextPermutation(arr4);
        assertThat(arr4).isEqualTo(new int[]{1, 1, 5});

        int[] arr6 = new int[]{1, 2, 6, 7, 5};
        nextPermutation(arr6);
        assertThat(arr6).isEqualTo(new int[]{1, 2, 7, 5, 6});
    }
}