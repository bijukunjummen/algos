package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        //sort by start time.
        Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));
        List<int[]> result = new ArrayList<>();
        int[] anchor = intervals[0];
        result.add(anchor);

        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (overLaps(anchor, currInterval)) {
                if (currInterval[1] > anchor[1]) anchor[1] = currInterval[1];
            } else {
                result.add(currInterval);
                anchor = currInterval;
            }
        }

        return result.toArray(new int[0][0]);
    }

    private boolean overLaps(int[] int1, int[] int2) {
        if (int2[0] <= int1[1]) {
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