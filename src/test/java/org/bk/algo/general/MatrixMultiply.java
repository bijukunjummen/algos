package org.bk.algo.general;

class MatrixMultiply {
    public int[][] multiply(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = (B.length > 0) ? B[0].length:0;
        
        int[][] result = new int[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[r][c] = prod(r, c, A, B);
            }
        }
        return result;
    }
    
    private int prod(int r, int c, int[][] A, int[][] B) {
        int sum = 0;
        for (int a = 0; a < A[r].length; a++) {
            sum += A[r][a] * B[a][c];
        }
        return sum;
    }
}