package org.bk.algo.general.path;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        Map<Point, Integer> pointToDistance = new HashMap<>();
        int rows = heights.length;
        int cols = rows > 0 ? heights[0].length : 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                pointToDistance.put(new Point(new int[]{r, c}), Integer.MAX_VALUE);
            }
        }
        pointToDistance.put(new Point(new int[]{0, 0}), 0);
        PriorityQueue<PointAndDistance> minPq = new PriorityQueue<>(Comparator.comparing(p -> p.distance));
        minPq.add(new PointAndDistance(new int[]{0, 0}, 0));

        while (!minPq.isEmpty()) {
            relax(minPq.poll(), minPq, pointToDistance, heights);
        }
        return pointToDistance.get(new Point(new int[]{rows - 1, cols - 1}));
    }

    private void relax(PointAndDistance pointAndDistance, PriorityQueue<PointAndDistance> minPq, Map<Point, Integer> pointToDistance, int[][] heights) {
        int[] point = pointAndDistance.point;
        int distance = pointAndDistance.distance;
        List<int[]> neighbors = neighbors(point, heights);
        for (int[] neighbor : neighbors) {
            int distToNeighbor = distanceTo(point, neighbor, heights, distance);
            PointAndDistance neighborPointAndDistance = new PointAndDistance(neighbor, distToNeighbor);
            if (pointToDistance.get(new Point(neighbor)) > distToNeighbor) {
                pointToDistance.put(new Point(neighbor), distToNeighbor);
                if (!minPq.contains(neighborPointAndDistance)) {
                    minPq.add(neighborPointAndDistance);
                } else {
                    minPq.remove(neighborPointAndDistance);
                    minPq.add(neighborPointAndDistance);
                }
            }
        }
    }

    private int distanceTo(int[] point, int[] neighbor, int[][] heights, int distance) {
        return Math.max(distance,
                Math.abs(heights[point[0]][point[1]] - heights[neighbor[0]][neighbor[1]]));
    }

    private List<int[]> neighbors(int[] point, int[][] grid) {
        int r = point[0];
        int c = point[1];
        int rows = grid.length;
        int cols = rows > 0 ? grid[0].length : 0;
        List<int[]> neighbors = new ArrayList<>();
        if (r - 1 >= 0) {
            neighbors.add(new int[]{r - 1, c});
        }
        if (r + 1 <= rows - 1) {
            neighbors.add(new int[]{r + 1, c});
        }

        if (c - 1 >= 0) {
            neighbors.add(new int[]{r, c - 1});
        }
        if (c + 1 <= cols - 1) {
            neighbors.add(new int[]{r, c + 1});
        }
        return neighbors;
    }

    static class Point {
        int[] point;

        Point(int[] point) {
            this.point = point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point1 = (Point) o;
            return Arrays.equals(point, point1.point);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(point);
        }
    }

    static class PointAndDistance {
        int[] point;
        int distance;

        PointAndDistance(int[] point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointAndDistance that = (PointAndDistance) o;
            return Arrays.equals(point, that.point);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(point);
        }
    }

    @Test
    void testMinPath() {
        assertThat(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}})).isEqualTo(2);
        assertThat(minimumEffortPath(new int[][]{{3}})).isEqualTo(0);
    }
}