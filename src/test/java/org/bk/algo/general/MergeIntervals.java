package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (overLaps(curr, intervals[i])) {
                curr = mergeIntervals(curr, intervals[i]);
            } else {
                result.add(curr);
                curr = intervals[i];
            }
        }
        result.add(curr);
        return result.toArray(new int[0][0]);
    }

    private int[] mergeIntervals(int[] a, int[] b) {
        return new int[] {a[0], Math.max(a[1], b[1])};
    }

    private boolean overLaps(int[] a, int[] b) {
        if (b[0] <= a[1]) {
            return true;
        }
        return false;
    }

    @Test
    void testMerge() {
        int[][] arr = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] result = merge(arr);

        assertThat(result).isEqualTo(new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        });
    }
}