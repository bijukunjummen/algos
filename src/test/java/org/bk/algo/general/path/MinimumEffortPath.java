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
        final Map<Point, Integer> pointToDistance = new HashMap<>();
        int rows = heights.length;
        int cols = rows > 0 ? heights[0].length : 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                pointToDistance.put(new Point(new int[]{r, c}), Integer.MAX_VALUE);
            }
        }
        pointToDistance.put(new Point(new int[]{0, 0}), 0);
        PriorityQueue<Point> minPq = new PriorityQueue<>(Comparator.comparing(p -> pointToDistance.get(p)));
        minPq.add(new Point(new int[]{0, 0}));

        while (!minPq.isEmpty()) {
            relax(minPq.poll(), minPq, pointToDistance, heights);
        }
        return pointToDistance.get(new Point(new int[]{rows - 1, cols - 1}));
    }

    private void relax(Point p, PriorityQueue<Point> minPq, Map<Point, Integer> pointToDistance, int[][] heights) {
        int[] point = p.point;
        int distance = pointToDistance.get(p);
        List<int[]> neighbors = neighbors(point, heights);
        for (int[] neighbor : neighbors) {
            int distToNeighbor = distanceTo(point, neighbor, heights, distance);
            Point neighborPoint = new Point(neighbor);
            if (pointToDistance.get(neighborPoint) > distToNeighbor) {
                pointToDistance.put(neighborPoint, distToNeighbor);
                if (!minPq.contains(neighborPoint)) {
                    minPq.add(neighborPoint);
                } else {
                    minPq.remove(neighborPoint);
                    minPq.add(neighborPoint);
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

    @Test
    void testMinPath() {
        assertThat(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}})).isEqualTo(2);
        assertThat(minimumEffortPath(new int[][]{{3}})).isEqualTo(0);
    }
}