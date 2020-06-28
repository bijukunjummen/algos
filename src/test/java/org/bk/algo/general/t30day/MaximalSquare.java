package org.bk.algo.general.t30day;

class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;

        int maxSquareSize = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    int squareSize = checkMaxSquareAt(row, col, matrix);
                    if (squareSize > maxSquareSize) {
                        maxSquareSize = squareSize;
                    }
                }
            }
        }

        return maxSquareSize * maxSquareSize;

    }

    private int checkMaxSquareAt(int row, int col, char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int sqSize = 1;
        for (int r = row + 1, c = col + 1; r < rows && c < cols; r++, c++) {
            if (!allOnes(row, col, r, c, matrix)) {
                break;
            } else {
                sqSize++;
            }
        }
        return sqSize;
    }

    private boolean allOnes(int row, int col, int r, int c, char[][] matrix) {
        for (int currCol = col; currCol <= c; currCol++) {
            if (matrix[r][currCol] == '0') {
                return false;
            }
        }

        for (int currRow = row; currRow <= r; currRow++) {
            if (matrix[currRow][c] == '0') {
                return false;
            }
        }
        return true;
    }
}