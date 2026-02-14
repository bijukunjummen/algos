package org.bk.algo.general.path;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LatestDayToCross {

    public int latestDayToCross(int row, int col, int[][] cells) {
        int numberOfDays = cells.length;

        int lo = 1;
        int hi = numberOfDays;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;

            if (bfs(mid, cells, row, col)) {
                lo = mid;
            } else  {
                hi = mid - 1;
            }
        }

        return lo;
    }

    record Cell(int row, int col) {
    }

    private boolean bfs(int d, int[][] cells, int rowCount, int colCount) {

        int[][] terr = populateCell(rowCount, colCount);

        for (int i = 0; i < d; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            terr[r][c] = 1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Cell> visited = new HashSet<>();
        for (int c = 0; c < colCount; c++) {
            if (terr[0][c] == 0) {
                queue.offer(new int[]{0, c});
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == rowCount - 1) {
                return true;
            }

            List<int[]> nextCells = getNextSetOfDirections(r, c, rowCount, colCount);
            for (int[] nextCell : nextCells) {
                int nextR = nextCell[0];
                int nextC = nextCell[1];
                if (!visited.contains(new Cell(nextR, nextC)) && terr[nextR][nextC] == 0) {
                    visited.add(new Cell(nextR, nextC));
                    queue.offer(nextCell);
                }
            }
        }
        return false;
    }

    private List<int[]> getNextSetOfDirections(int r, int c, int rowCount, int colCount) {
        List<int[]> nextCells = new ArrayList<>();
        if (r + 1 <= rowCount - 1) {
            nextCells.add(new int[]{r + 1, c});
        }
        if (c + 1 <= colCount - 1) {
            nextCells.add(new int[]{r, c + 1});
        }
        if (r - 1 >= 0) {
            nextCells.add(new int[]{r - 1, c});
        }
        if (c - 1 >= 0) {
            nextCells.add(new int[]{r, c - 1});
        }
        return nextCells;
    }

    private int[][] populateCell(int row, int col) {
        int[][] cells = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // 0 for land..
                cells[r][c] = 0;
            }
        }
        return cells;
    }

    @Test
    void testLatest() {
        assertThat(latestDayToCross(2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}})).isEqualTo(2);
        assertThat(latestDayToCross(2, 2, new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}})).isEqualTo(1);
        assertThat(latestDayToCross(3, 3, new int[][]{{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}}))
                .isEqualTo(3);
    }
}