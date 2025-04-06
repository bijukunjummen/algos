package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }

    public int minMeetingRooms2(int[][] intervals) {
        List<MeetingTime> meetingTimes = Arrays.stream(intervals).flatMap(i -> Stream.of(new MeetingTime(i[0], TimeType.S), new MeetingTime(i[1], TimeType.E)))
                .sorted(Comparator.comparingInt(MeetingTime::t)
                        .thenComparing(MeetingTime::type))
                .toList();

        Stack<MeetingTime> stack = new Stack<>();
        int maxMeetingRooms = Integer.MIN_VALUE;
        for (MeetingTime meetingTime : meetingTimes) {
            switch (meetingTime.type) {
                case S:
                    stack.push(meetingTime);
                    break;
                case E:
                    stack.pop();
                    break;
            }
            maxMeetingRooms = Math.max(maxMeetingRooms, stack.size());
        }
        return maxMeetingRooms;
    }

    record MeetingTime(int t, TimeType type) {

    }

    enum TimeType {
        E, S
    }

    @Test
    void testMeetings() {
        assertThat(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}})).isEqualTo(2);
        assertThat(minMeetingRooms(new int[][]{{7, 10}, {2, 4}})).isEqualTo(1);
        assertThat(minMeetingRooms(new int[][]{{0, 5}, {3, 7}, {4, 8}, {9, 10}, {11, 12}})).isEqualTo(3);
        assertThat(minMeetingRooms(new int[][]{{13, 15}, {1, 13}})).isEqualTo(1);
    }

    @Test
    void testMeetings2() {
        assertThat(minMeetingRooms2(new int[][]{{0, 30}, {5, 10}, {15, 20}})).isEqualTo(2);
        assertThat(minMeetingRooms2(new int[][]{{7, 10}, {2, 4}})).isEqualTo(1);
        assertThat(minMeetingRooms2(new int[][]{{0, 5}, {3, 7}, {4, 8}, {9, 10}, {11, 12}})).isEqualTo(3);
        assertThat(minMeetingRooms2(new int[][]{{13, 15}, {1, 13}})).isEqualTo(1);
    }
}