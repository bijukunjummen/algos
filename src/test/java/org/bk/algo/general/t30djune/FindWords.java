package org.bk.algo.general.t30djune;

import java.util.List;

class FindWords {
    public List<String> findWords(char[][] board, String[] words) {
        return List.of();
    }

    void findWords(char[][] board, int r, int c, String prefix, String[] words) {
        int R = board.length;
        int C = (R > 0) ? board[0].length : 0;

        String nextWord = prefix + board[r][c];

    }
}