package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubArraySumToK {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i - 1];
        }
        int count = 0;

        for (int s = 0; s < nums.length; s++) {
            for (int e = s; e < nums.length; e++) {
                if (diff(s, e, sum) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int diff(int s, int e, int[] sum) {
        return sum[e + 1] - sum[s];
    }

    @Test
    void testSumOfK() {
        assertThat(subarraySum(new int[]{1, 1, 1}, 2)).isEqualTo(2);
        assertThat(subarraySum(new int[]{1, 2, 3}, 3)).isEqualTo(2);
    }
}