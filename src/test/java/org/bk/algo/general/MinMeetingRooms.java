package org.bk.algo.general;

import org.assertj.core.api.Assertions;
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
            list.add(new Interval(v[0], v[1], "start", i));
            list.add(new Interval(v[1], v[0], "end", i));
        }
        list.sort((i1, i2) -> {
            if (i1.t != i2.t) {
                return i1.t - i2.t;
            } else {
                return i1.o - i2.o;
            }

        });

        int min = 0;
        int parallel = 0;
        for (Interval ival : list) {
            if (ival.s.equals("start")) {
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
        int meetingRooms = 0;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        minPq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] > minPq.peek()[1]) {
                minPq.poll();
            }
            minPq.add(interval);
            meetingRooms = Math.max(meetingRooms, minPq.size());
        }
        return meetingRooms;
    }


    static class Interval {
        int t;
        int o;
        String s;
        int idx;

        Interval(int t, int o, String s, int idx) {
            this.t = t;
            this.o = o;
            this.s = s;
            this.idx = idx;
        }
    }

    @Test
    void testMeetings() {
        assertThat(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}})).isEqualTo(2);
        assertThat(minMeetingRooms(new int[][]{{7, 10}, {2, 4}})).isEqualTo(1);
    }

    @Test
    void testMeetings2() {
        assertThat(minMeetingRooms2(new int[][]{{0, 30}, {5, 10}, {15, 20}})).isEqualTo(2);
        assertThat(minMeetingRooms2(new int[][]{{7, 10}, {2, 4}})).isEqualTo(1);
    }
}