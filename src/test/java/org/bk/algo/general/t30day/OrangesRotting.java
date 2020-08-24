package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int rounds = 0;
        while (!isAllRotten(grid)) {
            int[][] newGrid = mutate(grid);
            if (isSame(newGrid, grid)) {
                return -1;
            }
            grid = newGrid;

            rounds++;
        }
        return rounds;
    }

    private boolean isAllRotten(int[][] grid) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSame(int[][] grid, int[][] newState) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != newState[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] mutate(int[][] grid) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;
        int[][] newState = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                newState[r][c] = grid[r][c];
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    changeNeighbors(grid, r, c, newState);
                }
            }
        }
        return newState;
    }

    private void changeNeighbors(int[][] grid, int r, int c, int[][] newState) {
        if (r - 1 >= 0 && newState[r - 1][c] != 0) newState[r - 1][c] = 2;
        if (r + 1 <= grid.length - 1 && newState[r + 1][c] != 0) newState[r + 1][c] = 2;
        if (c - 1 >= 0 && newState[r][c - 1] != 0) newState[r][c - 1] = 2;
        if (c + 1 <= grid[0].length - 1 && newState[r][c + 1] != 0) newState[r][c + 1] = 2;
    }

    @Test
    void testOranges1() {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

        assertThat(orangesRotting(grid)).isEqualTo(4);
    }
}