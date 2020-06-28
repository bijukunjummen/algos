package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NonDups {
    public int singleNonDuplicate(int[] nums) {
        Integer n = nonDup(nums, 0, nums.length - 1);
        if (n == null) {
            return -1;
        }
        return n;
    }

    private Integer nonDup(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;

        int n = nums[mid];
        if (isDup(nums, n, mid)) {
            Integer left = nonDup(nums, lo, mid - 1);
            if (left != null) return left;
            return nonDup(nums, mid + 1, hi);
        } else {
            return n;
        }

    }

    private boolean isDup(int[] nums, int n, int idx) {
        return (idx - 1 >= 0 && nums[idx - 1] == n) || (idx + 1 < nums.length && nums[idx + 1] == n);
    }


    @Test
    void test1() {
        assertThat(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8})).isEqualTo(2);
        assertThat(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11})).isEqualTo(10);
    }
}