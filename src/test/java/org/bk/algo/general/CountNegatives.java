package org.bk.algo.general;

import org.junit.jupiter.api.Test;

class CountNegatives {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = (n > 0)? grid[0].length:0;

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += m - findNegInRow(i, grid);
        }
        return count;
    }

    private int findNegInRow(int r, int[][] grid) {
        int[] row = grid[r];
        
        int lo = 0;
        int hi = row.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if (row[mid] < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    @Test
    void countNegativesTest() {
        int r = findNegInRow(1, new int[][] {{5, 4, 3, 2}, {4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}});
        System.out.println(r);
    }


}