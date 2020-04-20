package org.bk.algo.general;

import org.junit.jupiter.api.Test;

public class AndroidUnlockPatterns {
    private static final int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    public int numberOfPatterns(int m, int n) {
        String[][] visited = new String[3][3];
        Counter counter = new Counter();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                numberOfPatterns(m, n, r, c, visited, "", counter);
            }
        }
        return counter.counter;
    }

    private void numberOfPatterns(int m, int n, int r, int c, String[][] visited, String prefix, Counter counter) {
        if (visited[r][c] != null && prefix.equals(visited[r][c])) {
            return;
        }

        // System.out.println("r = " + r + ", c=" + c + ", prefix=" + prefix + ", visited=" + visited[r][c]);

        String s;

        // if (visited[r][c] != null) {
        //     s = prefix;
        // } else {
            s = prefix + grid[r][c];
            if (s.length() >= m && s.length() <= n) {
                System.out.println(s);
                counter.counter++;
            }
        // }
        visited[r][c] = prefix;

        if (s.length() >= n) {
            return;
        }

        for (int i = r - 1; (i <= r + 1) && i < 3; i++) {
            for (int j = c - 1; (j <= c + 1) && j < 3; j++) {
                if (i >= 0 && j >= 0 && !(i == r && j== c)) {
                    numberOfPatterns(m, n, i, j, visited, s, counter);
                }
            }
        }

        visited[r][c] = null;
    }

    class Counter {
        int counter;
    }

    @Test
    void testCombinations() {
        System.out.println(numberOfPatterns(1, 2));

        // int r = 0; int c = 0;
        // for (int i = r - 1; (i <= r + 1) && i < 3; i++) {
        //     for (int j = c - 1; (j <= c + 1) && j < 3; j++) {
        //         if (i >= 0 && j >= 0 && !(i == r && j== c)) {
        //             System.out.println("i = " + i + ", j = " + j);
        //         }
        //         // if (!(i == r && j == c)) {
        //         //     numberOfPatterns(m, n, i, j, visited, s, counter);
        //         // }
        //     }
        // }
    }

}
