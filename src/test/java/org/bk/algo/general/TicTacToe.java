package org.bk.algo.general;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
public class TicTacToe {
    public String tictactoe(int[][] moves) {
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        showState(board);
        int person = 1;
        for (int[] move : moves) {
            makeMoveOnBoard(board, move, person);
            if (isWinner(board, person, move)) {
                return letterForPerson(person);
            }
            person = otherPerson(person);
            showState(board);
        }
        return "PENDING";
    }

    private boolean isWinner(int[][] board, int person, int[] position) {
        return
                checkHor(board, position, person)
                        || checkVert(board, position, person)
                        || checkDiag(board, position, person);
    }

    private boolean checkDiag(int[][] board, int[] position, int person) {
        int r = position[0];
        int c = position[1];

        return false;
    }

    private boolean checkVert(int[][] board, int[] position, int person) {
        int c = position[1];
        for (int i = 0; i < 3; i++) {
            if (board[i][c] != person) {
                return false;
            }
        }
        return true;
    }

    private boolean checkHor(int[][] board, int[] position, int person) {
        int r = position[0];

        for (int j = 0; j < 3; j++) {
            if (board[r][j] != person) {
                return false;
            }
        }

        return true;
    }

    private String letterForPerson(int person) {
        if (person == 1) {
            return "A";
        }

        return "B";
    }

    private int otherPerson(int person) {
        if (person == 1) {
            return 2;
        }

        if (person == 2) {
            return 1;
        }

        return 0;
    }

    private void showState(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //1 is A, 2 is B
    private void makeMoveOnBoard(int[][] state, int[] move, int person) {
        state[move[0]][move[1]] = person;
    }

    @Test
    void testMoves() {
        int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        assertThat(tictactoe(moves)).isEqualTo("A");
    }
}
