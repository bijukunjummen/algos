package org.bk.algo.general;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int firstEnd = points[0][1];
        int count = 1;
        int xStart, xEnd;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            xStart = p[0];
            xEnd = p[1];
            if (xStart > firstEnd) {
                count++;
                firstEnd = xEnd;
            }
        }
        return count;
    }

    @ParameterizedTest
    @MethodSource("rawdata")
    void testMinArrowShots(int[][] points, int expected) {
        assertThat(findMinArrowShots(points)).isEqualTo(expected);
    }

    static Stream<Arguments> rawdata() {
        return Stream.of(
                Arguments.of(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2),
                Arguments.of(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4),
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2)
        );
    }

}