package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

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
        int left = lo;
        if (nums[left] == target) {
            int right = left;
            while (right + 1 < nums.length && nums[right + 1] == target) {
                right++;
            }
            return new int[]{left, right};

        } else {
            return new int[]{-1, -1};
        }
    }

    int getHighMark(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else { // target == nums[mid]
                lo = mid;
            }
        }
        return lo;
    }

    int getLowMark(int[] nums, int target) {
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
        return lo;
    }

    @Test
    void testSearchRange() {
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10, 12, 13, 14, 15}, 8)).isEqualTo(new int[]{3, 4});
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10, 12, 13, 14, 15}, 6)).isEqualTo(new int[]{-1, -1});
        assertThat(searchRange(new int[]{}, 6)).isEqualTo(new int[]{-1, -1});
        assertThat(searchRange(new int[]{1}, 1)).isEqualTo(new int[]{0, 0});
    }

    @Test
    void testHighAndLowMark() {
        assertThat(getHighMark(new int[]{5, 7, 7, 8, 8, 10, 12, 13, 14, 15}, 8)).isEqualTo(4);
//        assertThat(getLowMark(new int[]{5, 7, 7, 8, 8, 10, 12, 13, 14, 15}, 8)).isEqualTo(3);
//        assertThat(getLowMark(new int[]{5, 7, 7, 8, 8, 10, 12, 13, 14, 15}, 5)).isEqualTo(0);
    }
}
