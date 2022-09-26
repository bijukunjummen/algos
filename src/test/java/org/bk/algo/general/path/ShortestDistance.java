package org.bk.algo.general.path;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class ShortestDistance {
    public int shortestDistance(int[][] grid) {
        Map<Point, List<Point>> graph = createGraph(grid);
        List<Point> buildings = findAllBuildings(graph);

        int rows = grid.length;
        int cols = rows > 0 ? grid[0].length : 0;
        int minPath = Integer.MAX_VALUE;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    int distanceForBuildings = calculateDistanceForAllBuildings(buildings, graph, grid[r][c], r, c);
                    if (!(distanceForBuildings == Integer.MAX_VALUE)) {
                        if (distanceForBuildings < minPath) {
                            minPath = distanceForBuildings;
                        }
                    }
                }
            }
        }

        if (minPath == Integer.MAX_VALUE) return -1;
        return minPath;
    }


    private List<Point> findAllBuildings(Map<Point, List<Point>> graph) {
        List<Point> buildings = new ArrayList<>();
        for (Point point : graph.keySet()) {
            if (point.g == 1) {
                buildings.add(point);
            }
        }
        return buildings;
    }

    private int calculateDistanceForAllBuildings(List<Point> buildings, Map<Point, List<Point>> graph, int g, int r, int c) {
        ShortestPath shortestPath = new ShortestPath(graph, new Point(r, c, g));
        int pathForBuildingAtPoint = 0;
        for (Point building : buildings) {
            int pathForBuilding = shortestPath.getDistance(building);
            if (pathForBuilding == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            pathForBuildingAtPoint += pathForBuilding;
        }
        return pathForBuildingAtPoint;
    }

    static class ShortestPath {
        Map<Point, Integer> pointToDistance = new HashMap<>();
        Map<Point, List<Point>> graph;

        ShortestPath(Map<Point, List<Point>> graph, Point source) {
            this.graph = graph;
            for (Point point : this.graph.keySet()) {
                pointToDistance.putIfAbsent(point, Integer.MAX_VALUE);
            }

            pointToDistance.put(source, 0);
            PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> pointToDistance.get(o)));
            pq.add(source);
            while (!pq.isEmpty()) {
                relax(pq.poll(), pq);
            }
        }

        private void relax(Point point, PriorityQueue<Point> pq) {
            if (point.g == 1) {
                return;
            }

            int distance = pointToDistance.get(point);

            for (Point neighbor : graph.get(point)) {
                if (pointToDistance.get(neighbor) > distance + 1) {
                    pointToDistance.put(neighbor, distance + 1);
                    if (pq.contains(neighbor)) {
                        pq.remove(neighbor);
                    }
                    pq.add(neighbor);
                }
            }
        }

        private int getDistance(Point building) {
            return pointToDistance.get(building);
        }
    }

    private Map<Point, List<Point>> createGraph(int[][] grid) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;
        Map<Point, List<Point>> result = new HashMap<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0 || grid[r][c] == 1) {
                    Point p = new Point(r, c, grid[r][c]);
                    result.computeIfAbsent(p, k -> new ArrayList<>());
                    List<Point> neighbors = getValidNeighbors(r, c, grid, result);
                    result.get(p).addAll(neighbors);
                }
            }
        }
        return result;
    }

    private List<Point> getValidNeighbors(int row, int col, int[][] grid, Map<Point, List<Point>> result) {
        List<Point> neighbors = new ArrayList<>();
        if (isValid(grid, row - 1, col)) {
            neighbors.add(new Point(row - 1, col, grid[row - 1][col]));
        }
        if (isValid(grid, row + 1, col)) {
            neighbors.add(new Point(row + 1, col, grid[row + 1][col]));
        }
        if (isValid(grid, row, col - 1)) {
            neighbors.add(new Point(row, col - 1, grid[row][col - 1]));
        }
        if (isValid(grid, row, col + 1)) {
            neighbors.add(new Point(row, col + 1, grid[row][col + 1]));
        }
        return neighbors;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;
        return (r >= 0 && r < rows && c >= 0 && c < cols && (grid[r][c] == 0 || grid[r][c] == 1));
    }

    static class Point {
        int r;
        int c;
        int g;

        Point(int r, int c, int g) {
            this.r = r;
            this.c = c;
            this.g = g;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public boolean equals(Object other) {
            Point otherPoint = (Point) other;
            return r == otherPoint.r && c == otherPoint.c;
        }
    }
}