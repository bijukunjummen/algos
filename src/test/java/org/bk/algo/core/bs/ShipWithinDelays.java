package org.bk.algo.core.bs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ShipWithinDelays {
    public int shipWithinDays(int[] weights, int days) {
        int l = weights[weights.length - 1];
        int r = Arrays.stream(weights).sum();

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (feasible(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean feasible(int[] weights, int capacity, int days) {
        int total = 0;
        int d = 0;
        int current = 0;
        while (current < weights.length) {
            int w = weights[current];
            total += w;
            if (total > capacity) {
                total = 0;
                d++;
                if (d > days) {
                    return false;
                }
            } else if (current == weights.length - 1) {
                d++; // increase if the weight is the last one
                if (d > days) {
                    return false;
                }
                current++;
            } else {
                current++;
            }
        }
//        System.out.println(d + " days");
        return true;
    }

    @Test
    void testFeasible() {
        assertThat(new ShipWithinDelays().feasible(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3, 5)).isFalse();
        assertThat(new ShipWithinDelays().feasible(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15, 5)).isTrue();
        assertThat(new ShipWithinDelays().feasible(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 11, 5)).isFalse();
    }

    @Test
    void testShipDelay() {
        assertThat(new ShipWithinDelays().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)).isEqualTo(15);
    }

}