package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class MazePath {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Coord startCoord = new Coord(start[0], start[1]);
        Coord destCoord = new Coord(destination[0], destination[1]);
        Set<Path> visited = new HashSet<>();

        Path startPath = new Path(startCoord, null, new ArrayList<>());
        Queue<Path> queue = new ArrayDeque<>();
        queue.add(startPath);
        while (!queue.isEmpty()) {
            Path currentPath = queue.poll();
            visited.add(currentPath);
            if (currentPath.coord.equals(destCoord) && willHitWall(maze, currentPath.coord, currentPath.lastMove)) {
                return true;
            }
            queue.addAll(nextPaths(maze, currentPath, visited));
        }
        return false;
    }

    private List<Path> nextPaths(int[][] maze, Path currentPath, Set<Path> visited) {
        int rows = maze.length;
        int cols = (rows > 0) ? maze[0].length : 0;

        if (willHitWall(maze, currentPath.coord, currentPath.lastMove)) {
            List<Path> possibleNextPaths = new ArrayList<>();
            if (currentPath.coord.col > 0
                    && maze[currentPath.coord.row][currentPath.coord.col - 1] != 1) {
                Path nextPath = currentPath.extend(Move.LEFT);
                if (!visited.contains(nextPath)) possibleNextPaths.add(nextPath);
            }
            if (currentPath.coord.col < cols - 1
                    && maze[currentPath.coord.row][currentPath.coord.col + 1] != 1) {
                Path nextPath = currentPath.extend(Move.RIGHT);
                if (!visited.contains(nextPath)) possibleNextPaths.add(nextPath);
            }
            if (currentPath.coord.row > 0
                    && maze[currentPath.coord.row - 1][currentPath.coord.col] != 1) {

                final Path nextPath = currentPath.extend(Move.UP);
                if (!visited.contains(nextPath)) possibleNextPaths.add(nextPath);
            }
            if (currentPath.coord.row < rows - 1
                    && maze[currentPath.coord.row + 1][currentPath.coord.col] != 1) {
                final Path nextPath = currentPath.extend(Move.DOWN);
                if (!visited.contains(nextPath)) possibleNextPaths.add(nextPath);
            }
            return possibleNextPaths;
        } else {
            // continue in the same direction
            if (currentPath.lastMove == null) {
                throw new IllegalStateException("Last move not expected to be null..");
            }
            Move newMove = currentPath.lastMove;
            final Path nextPath = currentPath.extend(newMove);
            if (!visited.contains(nextPath)){
                return List.of(nextPath);
            }
        }
        return List.of();
    }

    private boolean willHitWall(int[][] maze, Coord coord, Move lastMove) {
        int rows = maze.length;
        int cols = (rows > 0) ? maze[0].length : 0;
        if (rows == 0 || cols == 0) {
            return true;
        }
        if (lastMove == null) {
            return true;
        } else {
            switch (lastMove) {
                case UP:
                    return coord.row - 1 < 0 || maze[coord.row - 1][coord.col] == 1;
                case DOWN:
                    return coord.row + 1 > rows - 1 || maze[coord.row + 1][coord.col] == 1;
                case LEFT:
                    return coord.col - 1 < 0 || maze[coord.row][coord.col - 1] == 1;
                case RIGHT:
                    return coord.col + 1 > cols - 1 || maze[coord.row][coord.col + 1] == 1;
            }
        }

        return false;
    }

    private enum Move {
        UP, DOWN, LEFT, RIGHT
    }

    private static class Coord {
        int row;
        int col;

        Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coord)) return false;

            Coord coord = (Coord) o;

            if (row != coord.row) return false;
            return col == coord.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    private static class Path {
        private Coord coord;
        private Move lastMove;
        private List<Move> history;

        public Path(Coord coord, Move lastMove, List<Move> history) {
            this.coord = coord;
            this.lastMove = lastMove;
            this.history = history;
        }

        public Path extend(Move move) {
            List<Move> newHistory = new ArrayList<>(this.history);
            newHistory.add(move);
            switch (move) {
                case UP:
                    return new Path(new Coord(coord.row - 1, coord.col), move, newHistory);
                case DOWN:
                    return new Path(new Coord(coord.row + 1, coord.col), move, newHistory);
                case LEFT:
                    return new Path(new Coord(coord.row, coord.col - 1), move, newHistory);
                case RIGHT:
                    return new Path(new Coord(coord.row, coord.col + 1), move, newHistory);
            }
            throw new IllegalStateException("Should not be possible for move: " + move);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;

            Path path = (Path) o;

            if (!Objects.equals(coord, path.coord)) return false;
            return lastMove == path.lastMove;
        }

        @Override
        public int hashCode() {
            int result = coord != null ? coord.hashCode() : 0;
            result = 31 * result + (lastMove != null ? lastMove.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            String moves = history.stream().map(move -> move.toString()).collect(Collectors.joining(", "));
            return "Moves: " + moves + " to reach destination: " + coord;
        }
    }

    // @Test
    // void testAtWall() {
    //     int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0,
    //     0, 0}};
    //     assertThat(willHitWall(maze, new Coord(0, 0))).isTrue();
    //     assertThat(willHitWall(maze, new Coord(0, 1))).isTrue();
    //     assertThat(willHitWall(maze, new Coord(1, 2))).isTrue();
    //     assertThat(willHitWall(maze, new Coord(1, 2))).isTrue();
    //     assertThat(willHitWall(maze, new Coord(0, 4))).isTrue();
    // }

    @Test
    void testMazePath1() {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        assertThat(hasPath(maze, new int[]{0, 4}, new int[]{4, 4})).isTrue();
    }

    @Test
    void testMazePath2() {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        assertThat(hasPath(maze, new int[]{0, 4}, new int[]{3, 2})).isFalse();
    }

    @Test
    void testMazePath3() {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        assertThat(hasPath(maze, new int[]{1, 1}, new int[]{1, 2})).isTrue();
    }
}