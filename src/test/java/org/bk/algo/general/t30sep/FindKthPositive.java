package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0] - 1) {
            return k;
        }
        k -= arr[0] - 1;
        for (int i = 0 ; i < arr.length - 1;i++ ) {
            int missing = arr[i + 1] - arr[i] - 1;
            if (k < missing) {
                return arr[i] + k;
            }
            k -= missing;
        }
        return arr[arr.length - 1] + k;
    }


    @Test
    void findKthPositive() {
        assertThat(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5)).isEqualTo(9);
        assertThat(findKthPositive(new int[]{1,2,3,4}, 2)).isEqualTo(6);
    }
}