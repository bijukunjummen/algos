package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContiguousArrayMaxLength {
    public int findMaxLength(int[] nums) {
        int[] zeros = new int[nums.length];
        int[] ones = new int[nums.length];

        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 0) {
                zeros[i] = ++zeroCount;
                ones[i] = oneCount;
            } else {
                ones[i] = ++oneCount;
                zeros[i] = zeroCount;
            }
        }

        for (int win = nums.length; win > 1; win = win - 1) {
            int length = getMaxLengthUsing(win, nums, zeros, ones);
            if (length > 0) {
                return length;
            }
        }

        return 0;
    }

    private int getMaxLengthUsing(int win, int[] nums, int[] zeros, int[] ones) {
        for (int i = 0; i <= nums.length - win; i++) {
            if (zeros[i + win - 1] - zeros[i] + (nums[i] == 0 ? 1 : 0) == ones[i + win - 1] - ones[i] + (nums[i] == 1 ? 1 : 0)) {
                return win;
            }
        }
        return 0;
    }


    @Test
    void testOfSubArray() {
        assertThat(findMaxLength(new int[]{0, 1})).isEqualTo(2);
        assertThat(findMaxLength(new int[]{0, 1, 0})).isEqualTo(2);
        assertThat(findMaxLength(new int[]{0, 1, 1, 0})).isEqualTo(4);
        assertThat(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1})).isEqualTo(6);
        assertThat(findMaxLength(new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1})).isEqualTo(68);
    }

}