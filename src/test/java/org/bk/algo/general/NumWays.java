package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class NumWays {
    private static final int MAX = (int) Math.pow(10, 9) + 7;

    public int numWays(int steps, int arrLen) {
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        return numWays(steps, 0, 0, arrLen, memo);
    }

    private int numWays(int steps, int currentStep, int position, int arrLen, Map<Integer, Map<Integer, Integer>> memo) {
        if (currentStep == steps) {
            if (position == 0) {
                return 1;
            }
            return 0;
        }
        if (memo.containsKey(position) && memo.get(position).containsKey(currentStep)) {
            return memo.get(position).get(currentStep);
        }
        List<Integer> nextPositions = new ArrayList<>();
        if (position - 1 >= 0) {
            nextPositions.add(position - 1);
        }
        if (position + 1 < arrLen) {
            nextPositions.add(position + 1);
        }

        nextPositions.add(position);
        int count = 0;
        for (int nextPosition : nextPositions) {
            count += numWays(steps, currentStep + 1, nextPosition, arrLen, memo);
            if (count > MAX) {
                count = count % MAX;
            }
        }
        Map<Integer, Integer> stepMap = memo.computeIfAbsent(position, k -> new HashMap<>());
        stepMap.put(currentStep, count);
        return count;
    }

    @Test
    void testNumWays() {
        assertThat(numWays(3, 2)).isEqualTo(4);
        assertThat(numWays(2, 4)).isEqualTo(2);
        assertThat(numWays(4, 2)).isEqualTo(8);
        assertThat(numWays(6, 13)).isEqualTo(51);
    }
}