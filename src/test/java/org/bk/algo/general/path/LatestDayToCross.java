package org.bk.algo.general.path;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LatestDayToCross {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] terr = populateCell(row, col);
        int d = 0;

        for (int[] cell : cells) {
            if (!isConnected(terr, row, col)) {
                return d;
            }
            d++;
            int r = cell[0] - 1;
            int c = cell[1] - 1;
            terr[r][c] = 1;

        }
    }

    private boolean isConnected(int[][] terr, int rowCount, int colCount) {
        int[] firstRow = terr[0];
        Map<Cell, Boolean> visited = new HashMap<>();
        for (int c = 0; c < terr[0].length; c++) {
            if (firstRow[c] == 0) {
                boolean connected = dfs(0,c,terr, rowCount, colCount, visited);
                if (connected) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int[][] terr, int rowCount, int colCount,  Map<Cell, Boolean> visited) {

    }

    private int[][] populateCell(int row, int col) {
        int[][] cells = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // 0 for land..
                cells[r][c] = 0;
            }
        }
    }

    record Cell(int r, int c) {

    }


    @Test
    void testLatest() {
        assertThat(latestDayToCross(2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}})).isEqualTo(2);
    }
}