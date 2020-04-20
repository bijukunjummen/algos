package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchNumsPivoted {
    public int search(int[] nums, int target) {
        // 4 5 6 7 0 1 2
        //pivotIndex is 4
        int pivotIndex = findPivot(nums);

        return binarySearch(nums, pivotIndex, target);

    }

    private int binarySearch(int[] nums, int pivotIndex, int target) {
        int idx = binarySearch(nums,
                pivotIndex,
                0 + pivotIndex,
                nums.length - 1 + pivotIndex,
                target);
        if (idx != -1) {
            return idx % nums.length;
        }
        return -1;
    }


    private int binarySearch(int[] nums, int pivotIndex, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        int atMid = nums[mid % nums.length];

        if (target > atMid) {
            return binarySearch(nums, pivotIndex, mid + 1, hi, target);
        } else if (target < atMid) {
            return binarySearch(nums, pivotIndex, lo, mid - 1, target);
        } else {
            return mid;
        }
    }

    private int findPivot(int[] nums) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == -1) {
            return 0;
        }
        return pivot;
    }

    private int findPivot(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return -1;
        }
        if (nums[lo] < nums[hi]) {
            return -1;
        }

        int mid = (lo + hi) / 2;

        int atMid = nums[mid];

        if (mid - 1 >= 0 && nums[mid - 1] > atMid) {
            return mid;
        }
        if (mid + 1 <= nums.length -1 && nums[mid + 1] < atMid) {
            return mid + 1;
        }


        if (nums[lo] > atMid) {
            return findPivot(nums, lo, mid);
        } else if (nums[hi] < atMid) {
            return findPivot(nums, mid, hi);
        }

        return -1;

    }

    @Test
    void findPivotTest() {
//        assertThat(findPivot(new int[]{4, 5, 6, 7, 0, 1, 2})).isEqualTo(4);
        assertThat(findPivot(new int[]{3, 1})).isEqualTo(1);
    }


    @Test
    void testPivotedSearch() {
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)).isEqualTo(4);
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6)).isEqualTo(2);
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)).isEqualTo(-1);
        assertThat(search(new int[]{3, 1}, 1)).isEqualTo(1);
        assertThat(search(new int[]{5, 1, 3}, 5)).isEqualTo(0);
        assertThat(search(new int[]{3, 4, 5, 6, 1, 2}, 2)).isEqualTo(5);
        assertThat(search(new int[]{1}, 1)).isEqualTo(0);
        assertThat(search(new int[]{1, 3}, 0)).isEqualTo(-1);

    }
}