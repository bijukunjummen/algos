package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubmatricesWithOne {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = rows > 0 ? mat[0].length : 0;
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                count += traverse(r, c, mat);
            }
        }
        return count;
    }

    private int traverse(int r, int c, int[][] mat) {
        int rows = mat.length;
        int cols = rows > 0 ? mat[0].length : 0;
        int count = 0;
        for (int p = r; p < rows; p++) {
            for (int q = c; q < cols; q++) {
                count += considerRect(r, c, p, q, mat);
            }
        }
        return count;
    }

    private int considerRect(int r, int c, int p, int q, int[][] mat) {
        for (int i = r; i <= p; i++) {
            for (int j = c; j <= q; j++) {
                if (mat[i][j] != 1) {
                    return 0;
                }
            }
        }
        return 1;
    }


    @Test
    void test1() {
        assertThat(numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}})).isEqualTo(13);
    }

    @Test
    void test2() {
        assertThat(numSubmat(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}})).isEqualTo(24);
    }
}