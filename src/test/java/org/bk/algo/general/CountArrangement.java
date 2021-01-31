package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class CountArrangement {
    public int countArrangement(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        AtomicInteger count = new AtomicInteger();
        permutation(0, arr, count);
        return count.get();
    }

    private void permutation(int idx, int[] arr, AtomicInteger count) {
        if (idx == arr.length - 1) {
            if (isBeautiful(arr, idx)) {
                count.incrementAndGet();
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            if (isBeautiful(arr, idx)) {
                permutation(idx + 1, arr, count);
            }
            swap(arr, idx, i);
        }
    }

    private boolean isBeautiful(int[] arr, int idx) {
        return (arr[idx] % (idx + 1) == 0) || ((idx + 1) % arr[idx] == 0);
    }

    private void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    @Test
    void testCountArrangement() {
        assertThat(countArrangement(1)).isEqualTo(1);
        assertThat(countArrangement(2)).isEqualTo(2);
        assertThat(countArrangement(3)).isEqualTo(3);
    }
}