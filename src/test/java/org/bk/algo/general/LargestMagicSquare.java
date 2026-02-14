//package org.bk.algo.general;
//
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class LargestMagicSquare {
//    public int largestMagicSquare(int[][] grid) {
//        int rows = grid.length;
//        int cols = rows > 0? grid[0].length : 0;
//        int largest = 1;
//        for (int r = 0; r < rows; r++) {
//            for (int c = 0; c < cols; c++) {
//                largest = Math.max(largest, largestWithLeftAt(grid, r, c));
//            }
//        }
//        return largest;
//    }
//
//    private int largetWithLeftAt(int[][] grid, int r, int c) {
//        int rows = grid.length;
//        int cols = rows > 0? grid[0].length : 0;
//
//
//    }
//
//    @Test
//    void testLargestMagicSquare() {
//        int[][] grid = {{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};
//    assertThat(largestMagicSquare(grid)).isEqualTo(3);
//    }
//}