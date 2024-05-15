package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (attempt(gas, cost, i, n)) {
                return i;
            }
        }
        return -1;
    }

    private boolean attempt(int[] gas, int[] cost, int idx, int n) {
        int currGas = 0;
        boolean first = true;
        for (int i = 0; i <= n; i++) {
            int curr = (i + idx) % n;
            if (!first && curr == idx && currGas >= 0) {
                return true;
            }
            if (!first && currGas <= 0) {
                return false;
            }

            first = false;
            currGas = currGas + gas[curr] - cost[curr];
        }
        return false;
    }

    @Test
    void testCircuit() {
        assertThat(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})).isEqualTo(3);
//        assertThat(attempt(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3, 5)).isTrue();
    }
}