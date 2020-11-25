package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumIslandsRaw {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = (rows > 0 ? grid[0].length : 0);
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    traverse(grid, r, c, visited);
                }
            }
        }
        return count;
    }

    private void traverse(char[][] grid, int r, int c, boolean[][] visited) {
        int rows = grid.length;
        int cols = (rows > 0 ? grid[0].length : 0);
        if (r > rows - 1 || r < 0) {
            return;
        }
        if (c > cols - 1 || c < 0) {
            return;
        }
        if (grid[r][c] == '0' || visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        traverse(grid, r - 1, c, visited);
        traverse(grid, r + 1, c, visited);
        traverse(grid, r, c - 1, visited);
        traverse(grid, r, c + 1, visited);
    }

    @Test
    void testIslands() {
        char[][] grid1 =
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };
        assertThat(numIslands(grid1)).isEqualTo(1);

        char[][] grid2 =
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };
        assertThat(numIslands(grid2)).isEqualTo(3);

        char[][] emptyGrid = {};
        assertThat(numIslands(emptyGrid)).isEqualTo(0);

    }
}