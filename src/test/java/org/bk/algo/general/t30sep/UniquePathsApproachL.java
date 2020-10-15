package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class UniquePathsApproachL {

    /**
     * Start: 1
     * End: 2
     * Empty: 0
     * Obstacle: -1
     */
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length : 0;
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    startRow = r;
                    startCol = c;
                }
                if (grid[r][c] == 2) {
                    endRow = r;
                    endCol = c;
                }
            }
        }
        return dfs(grid, startRow, startCol, endRow, endCol, rows, cols);
    }

    private int dfs(int[][] grid, int row, int col, int endRow, int endCol, int rows, int cols) {
        if (row == endRow && col == endCol) {
            if (unique(grid, rows, cols)) {
                return 1;
            } else {
                return 0;
            }
        }


        int temp = grid[row][col];
        grid[row][col] = -10;
        int res = 0;
        if (row + 1 < rows && !(grid[row + 1][col] < 0)) {
            res += dfs(grid, row + 1, col, endRow, endCol, rows, cols);
        }
        if (row - 1 >= 0 && !(grid[row - 1][col] < 0)) {
            res += dfs(grid, row - 1, col, endRow, endCol, rows, cols);
        }
        if (col + 1 < cols && !(grid[row][col + 1] < 0)) {
            res += dfs(grid, row, col + 1, endRow, endCol, rows, cols);
        }
        if (col - 1 >= 0 && !(grid[row][col - 1] < 0)) {
            res += dfs(grid, row, col - 1, endRow, endCol, rows, cols);
        }

        grid[row][col] = temp;
        return res;
    }

    private boolean unique(int[][] grid, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void testPath() {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        assertThat(uniquePathsIII(grid)).isEqualTo(2);
    }
}