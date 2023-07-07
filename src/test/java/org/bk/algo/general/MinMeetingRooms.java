package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] v = intervals[i];
            list.add(new Interval(v[0], v[1], TimeType.S, i));
            list.add(new Interval(v[1], v[0], TimeType.E, i));
        }
        list.sort((i1, i2) -> {
            if (i1.time != i2.time) {
                return i1.time - i2.time;
            } else {
                return i1.other - i2.other;
            }

        });

        int min = 0;
        int parallel = 0;
        for (Interval ival : list) {
            if (ival.timeType.equals(TimeType.S)) {
                parallel++;
                if (parallel > min) {
                    min = parallel;
                }
            } else {
                parallel--;
            }
        }
        return min;
    }

    public int minMeetingRooms2(int[][] intervals) {
        PriorityQueue<int[]> minPq = new PriorityQueue<>(Comparator.comparing(interval -> interval[1]));
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        minPq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= minPq.peek()[1]) {
                minPq.poll();
            }
            minPq.add(interval);
        }
        return minPq.size();
    }


    record Interval(int time, int other, TimeType timeType, int idx) {
    }

    enum TimeType {
        S, E
    }

    @Test
    void testMeetings() {
        assertThat(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}})).isEqualTo(2);
        assertThat(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {5, 10}, {10, 15}, {15, 20}})).isEqualTo(3);
        assertThat(minMeetingRooms(new int[][]{{7, 10}, {2, 4}})).isEqualTo(1);
        assertThat(minMeetingRooms(new int[][]{{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}})).isEqualTo(4);
    }

    @Test
    void testMeetings2() {
        assertThat(minMeetingRooms2(new int[][]{{0, 30}, {5, 10}, {15, 20}})).isEqualTo(2);
        assertThat(minMeetingRooms2(new int[][]{{7, 10}, {2, 4}})).isEqualTo(1);
        assertThat(minMeetingRooms2(new int[][]{{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}})).isEqualTo(4);
    }
}