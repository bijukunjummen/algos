package org.bk.algo.general.t30day;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubArraySumToK {
    public int subarraySum(int[] nums, int k) {
        int[] sumArr = getSumRange(nums);
        int countTotal = 0;
        for (int win = nums.length; win >= 1; win--) {
            countTotal += checkSumInWin(win, k, sumArr, nums);
        }

        return countTotal;
    }

    private int checkSumInWin(int win, int k, int[] sumArr, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - win + 1; i++) {
            if (sumRange(sumArr, nums, i, i + win -1) == k) {
                count++;
            }
        }
        return count;
    }

    private int[] getSumRange(int[] nums) {
        int length = nums.length;
        int[] sumArr = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + nums[i];
            sumArr[i] = sum;
        }
        return sumArr;
    }

    private int sumRange(int[] sumArr, int[] nums, int start, int end) {
        return sumArr[end] - sumArr[start] + nums[start];
    }

    @Test
    void testSumOfK() {
//        assertThat(subarraySum(new int[]{1, 1, 1}, 2)).isEqualTo(2);
        assertThat(subarraySum(new int[]{1, 2, 3}, 3)).isEqualTo(2);
    }

    @Test
    void testSumRange() {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] sumArr = getSumRange(nums);
        assertThat(sumRange(sumArr, nums, 0, 1)).isEqualTo(3);
        assertThat(sumRange(sumArr, nums, 0, 0)).isEqualTo(1);
        assertThat(sumRange(sumArr, nums, 1, 2)).isEqualTo(5);
        assertThat(sumRange(sumArr, nums, 2, 2)).isEqualTo(3);
        assertThat(sumRange(sumArr, nums, 1, 3)).isEqualTo(9);
    }
}