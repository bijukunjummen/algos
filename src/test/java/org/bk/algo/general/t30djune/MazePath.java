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
            if (currentPath.coord.equals(destCoord) && aWallInFront(maze, currentPath.coord, currentPath.lastMove)) {
                return true;
            }
            queue.addAll(nextPaths(maze, currentPath, visited));
        }
        return false;
    }

    private List<Path> nextPaths(int[][] maze, Path currentPath, Set<Path> visited) {
        Move lastMove = currentPath.lastMove;
        if (lastMove == null || aWallInFront(maze, currentPath.coord, lastMove)) {
            List<Path> potentialMoves = new ArrayList<>();
            if (!aWallInFront(maze, currentPath.coord, Move.UP)) {
                potentialMoves.add(currentPath.extend(Move.UP));
            }
            if (!aWallInFront(maze, currentPath.coord, Move.DOWN)) {
                potentialMoves.add(currentPath.extend(Move.DOWN));
            }
            if (!aWallInFront(maze, currentPath.coord, Move.LEFT)) {
                potentialMoves.add(currentPath.extend(Move.LEFT));
            }
            if (!aWallInFront(maze, currentPath.coord, Move.RIGHT)) {
                potentialMoves.add(currentPath.extend(Move.RIGHT));
            }
            return potentialMoves.stream().filter(path -> !visited.contains(path)).collect(Collectors.toList());
        } else {
            return List.of(currentPath.extend(lastMove));
        }

    }

    private boolean aWallInFront(int[][] maze, Coord current, Move move) {
        int rows = maze.length;
        int cols = (rows > 0) ? maze[0].length : 0;
        switch (move) {
            case UP:
                return current.row == 0 || maze[current.row - 1][current.col] == 1;
            case DOWN:
                return current.row == rows - 1 || maze[current.row + 1][current.col] == 1;
            case LEFT:
                return current.col == 0 || maze[current.row][current.col - 1] == 1;
            case RIGHT:
                return current.col == cols - 1 || maze[current.row][current.col + 1] == 1;
        }
        throw new IllegalStateException("Unexepcted move for a wall in front.");
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
        Coord coord;
        Move lastMove;
        List<Move> history;

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
            throw new IllegalStateException("Unexpected Move..!");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;
            Path path = (Path) o;
            return coord.equals(path.coord) &&
                    lastMove == path.lastMove;
        }

        @Override
        public int hashCode() {
            return Objects.hash(coord, lastMove);
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
        // int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        // assertThat(hasPath(maze, new int[]{1, 1}, new int[]{1, 2})).isTrue();

        var list = List.of("a", "b", "c");
        System.out.println(list.subList(0, 3));
    }
}