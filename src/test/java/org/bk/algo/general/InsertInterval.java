package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();
        int[][] insertedArr = insertNewInterval(intervals, newInterval);
        int[] current = insertedArr[0];
        for (int i = 1; i < insertedArr.length; i++) {
            if (overlaps(current, insertedArr[i])) {
               current = mergeIntervals(current, insertedArr[i]);
            } else {
                newIntervals.add(current);
                current = insertedArr[i];
            }
        }
        newIntervals.add(current);
        return newIntervals.toArray(new int[newIntervals.size()][]);
    }

    private int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();
        boolean added = false;
        for (int[] interval : intervals) {
            if ((interval[0] < newInterval[0]) || added) {
                newIntervals.add(interval);
            } else {
                newIntervals.add(newInterval);
                newIntervals.add(interval);
                added = true;
            }
        }
        if (!added) {
            newIntervals.add(newInterval);
        }
        return newIntervals.toArray(new int[newIntervals.size()][]);
    }

    private boolean overlaps(int[] a, int[] b) {
        return a[1] >= b[0];
    }

    private int[] mergeIntervals(int[] interval, int[] newInterval) {
        return new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
    }

    @Test
    void testMergeIntervals1() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] mergedIntervals = insert(intervals, newInterval);
        assertThat(mergedIntervals).isEqualTo(new int[][] {{1, 5}, {6, 9}});
    }
    @Test
    void testMergeIntervals2() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {6, 8};
        int[][] mergedIntervals = insert(intervals, newInterval);
        assertThat(mergedIntervals).isEqualTo(new int[][] {{1, 5}, {6, 8}});
    }
}