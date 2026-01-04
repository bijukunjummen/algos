package org.bk.algo.general.path;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestDistance {
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = rows > 0 ? grid[0].length : 0;
        int shortestDistance = Integer.MAX_VALUE;
        List<int[]> buildings = getBuildingCoordinates(grid, rows, cols);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    Map<Point, Integer> distTo = distanceToBuildings(r, c, rows, cols, grid);
                    Integer distance = calculateDistanceToBuildings(r, c, buildings, distTo);
//                    if (distance == null) {
//                        return -1;
//                    }
                    if (distance != null) {
                        shortestDistance = Math.min(shortestDistance, distance);
                    }
                }
            }
        }
        if  (shortestDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return shortestDistance;
    }

    private Integer calculateDistanceToBuildings(int r, int c, List<int[]> buildings, Map<Point, Integer> distTo) {
        int distance = 0;
        for (int[] b : buildings) {
            Point p = new Point(b[0], b[1]);
            if (distTo.containsKey(p)) {
                distance += distTo.get(p);
            } else {
                return null;
            }
        }
        return distance;
    }

    private List<int[]> getBuildingCoordinates(int[][] grid, int rows, int cols) {
        List<int[]> buildings = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    buildings.add(new int[]{r, c});
                }
            }
        }
        return buildings;
    }

    private Map<Point, Integer> distanceToBuildings(int r, int c, int rows, int cols, int[][] grid) {
        Map<Point, Integer> distTo = new HashMap<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        distTo.put(new Point(r, c), 0);
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
//            System.out.println("Considering point " + node[0] + ", " + node[1]);
            List<int[]> nextNodes = nextNodes(node[0], node[1], rows, cols, grid);
            for (int[] n : nextNodes) {
                if (!distTo.containsKey(new Point(n[0], n[1]))) {
                    distTo.put(new Point(n[0], n[1]), distTo.get(new Point(node[0], node[1])) + 1);
                    if (grid[n[0]][n[1]] == 0) {
                        queue.add(new int[]{n[0], n[1]});
                    }
                }
            }
        }
        return distTo;
    }

    private List<int[]> nextNodes(int r, int c, int rows, int cols, int[][] grid) {
        List<int[]> result = new ArrayList<>();
        if (c > 0) {
            result.add(new int[]{r, c - 1});
        }
        if (c < cols - 1) {
            result.add(new int[]{r, c + 1});
        }
        if (r < rows - 1) {
            result.add(new int[]{r + 1, c});
        }
        if (r > 0) {
            result.add(new int[]{r - 1, c});
        }

        return result;
    }

    @Test
    void testShortestDistance() {
//        assertThat(shortestDistance(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}})).isEqualTo(7);
        assertThat(shortestDistance(new int[][]{{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},{1,0,0,1,0,1},{1,0,1,0,0,1}
                ,{1,0,0,0,0,1},{0,1,1,1,1,0}})).isEqualTo(88);
    }

    record Point(int r, int c) {
    }
}