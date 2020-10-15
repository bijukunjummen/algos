package org.bk.algo.general.t30sep;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int sums = 0;
        for (int i = 0; i < nums.length; i++) {
            sums += subArraySums(i, nums, k);
        }
        return sums;
    }

    private int subArraySums(int idx, int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = idx; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
        }
        return count;
    }

    @Test
    void test() {
        int[] arr = {1, 2, 1, 2, 1};
        Assertions.assertThat(subarraySum(arr, 3)).isEqualTo(4);
    }
}