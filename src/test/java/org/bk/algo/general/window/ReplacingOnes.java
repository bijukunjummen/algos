package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int zeroCount = 0;
        int maxLength = 0;
        for (int s = 0, e = 0; e < arr.length; e++) {
            if (arr[e] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (arr[s] == 0) {
                    zeroCount--;
                }
                s++;
            }
            maxLength = Math.max(maxLength, e - s + 1);
        }
        return maxLength;
    }

    @Test
    void testFindLength() {
        assertThat(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2)).isEqualTo(6);
        assertThat(findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3)).isEqualTo(9);
    }
}
