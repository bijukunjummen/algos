package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                return false;
            } else {
                end = intervals[i][1];
            }
        }
        return true;
    }

    @Test
    void testCanAttendMeetings() {
        assertThat(canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}})).isFalse();
        assertThat(canAttendMeetings(new int[][]{{7, 10}, {2, 4}})).isTrue();
    }
}