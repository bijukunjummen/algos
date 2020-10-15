package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

class UniquePaths {
    public int uniquePathsIII(int[][] grid) {
        Coord start = findWithValue(grid, 1);
        Coord end = findWithValue(grid, 2);

        Set<Coord> covered = new HashSet<>();
        covered.add(start);
        Path startPath = new Path(start, covered);

        Queue<Path> queue = new ArrayDeque<>();
        int uniquePaths = 0;
        queue.add(startPath);
        while (!queue.isEmpty()) {
            Path path = queue.poll();
            if (path.coord.equals(end)) {
                if (checkIfUniquePath(grid, path)) {
                    uniquePaths++;
                }
            }
            queue.addAll(nextPaths(path, grid));
        }
        return uniquePaths;
    }

    private List<Path> nextPaths(Path currentPath, int[][] grid) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;
        List<Path> nextPaths = new ArrayList<>();
        Coord current = currentPath.coord;
        if ((current.r + 1) <= (rows - 1) && grid[current.r + 1][current.c] != -1) {
            addIfNotVisited(nextPaths, currentPath.extend(new Coord(current.r + 1, current.c)), currentPath);
        }
        if ((current.r - 1 >= 0) && grid[current.r - 1][current.c] != -1) {
            addIfNotVisited(nextPaths, currentPath.extend(new Coord(current.r - 1, current.c)), currentPath);
        }
        if ((current.c + 1 <= (cols - 1) && grid[current.r][current.c + 1] != -1)) {
            addIfNotVisited(nextPaths, currentPath.extend(new Coord(current.r, current.c + 1)), currentPath);
        }
        if ((current.c - 1 >= (0) && grid[current.r][current.c - 1] != -1)) {
            addIfNotVisited(nextPaths, currentPath.extend(new Coord(current.r, current.c - 1)), currentPath);
        }
        return nextPaths;
    }

    private void addIfNotVisited(List<Path> nextPaths, Path extend, Path current) {
        if (!current.covered.contains(extend.coord)) {
            nextPaths.add(extend);
        }
    }

    private boolean checkIfUniquePath(int[][] grid, Path path) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    if (!path.covered.contains(new Coord(r, c))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Coord findWithValue(int[][] grid, int n) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == n) {
                    return new Coord(r, c);
                }
            }
        }
        throw new IllegalStateException("Invalid grid value expectation: " + n);
    }

    private class Path {
        Coord coord;
        Set<Coord> covered;

        public Path(Coord coord, Set<Coord> covered) {
            this.coord = coord;
            this.covered = covered;
        }

        public Path extend(Coord coord) {
            Set newCovered = new HashSet<>(covered);
            newCovered.add(coord);
            return new Path(coord, newCovered);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Path.class.getSimpleName() + "[", "]")
                    .add("coord=" + coord)
                    .add("covered=" + covered)
                    .toString();
        }
    }

    private class Coord {
        int r;
        int c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coord)) return false;
            Coord coord = (Coord) o;
            return r == coord.r && c == coord.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Coord.class.getSimpleName() + "[", "]")
                    .add("r=" + r)
                    .add("c=" + c)
                    .toString();
        }
    }

    @Test
    void testPath() {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        assertThat(uniquePathsIII(grid)).isEqualTo(2);
    }
}