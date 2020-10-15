package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        PriorityQueue queue = new PriorityQueue(2, Comparator.reverseOrder());
        int sk = 00;
        for (int n = 1; n <= arr[arr.length -1]; n++) {
            if (!contains(arr, n)) {
                sk++;
            }
            if (sk == k) {
                return sk;
            }
        }
        return -1;
    }
    
    private boolean contains(int[] arr, int n) {
        int lo = 0;
        int hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi)/2;
            
            if (n == arr[mid]) {
                return true;
            } else if (n < arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    @Test
    void findKthPositive() {
        assertThat(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5)).isEqualTo(9);
    }
}