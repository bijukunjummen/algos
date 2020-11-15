package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MoveZerosLeft {

    public void moveZerosLeft(int[] arr) {
        int zIndex = arr.length - 1;
        int sIndex = arr.length - 1;
        while (true) {
            zIndex = findNextZeroIndex(zIndex, arr);
            if (zIndex == -1) {
                return;
            }

            if (sIndex > zIndex) sIndex = zIndex;

            sIndex = findNextNonZeroIndex(sIndex, arr);
            if (sIndex == -1) {
                return;
            }
            swap(arr, sIndex, zIndex);
            if (zIndex == 0 || sIndex == 0) break;
        }
    }

    private int findNextZeroIndex(int zIndex, int[] arr) {
        for (int idx = zIndex; idx >= 0; idx--) {
            if (arr[idx] == 0) {
                return idx;
            }
        }
        return -1;
    }

    private int findNextNonZeroIndex(int zIndex, int[] arr) {
        for (int idx = zIndex; idx >= 0; idx--) {
            if (arr[idx] != 0) {
                return idx;
            }
        }
        return -1;
    }


    private void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }

    @Test
    void testMove() {
        int[] arr = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        moveZerosLeft(arr);
        Assertions.assertThat(Arrays.equals(arr, new int[]{0, 0, 0, 1, 10, 20, 59, 63, 88})).isTrue();
    }
}
