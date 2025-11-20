package Recursion;
import java.util.*;
/*
Leetcode Que 51:

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 */
public class N_Queens {

// EXACT CODE AS SHOWN IN THE VIDEO (Shraddha Khapra N Queens)
// Java version written exactly same structure, variable names, flow.

    void nQueens(char[][] board, int row, int n, List<char[][]> ans) {
        if (row == n) {
            ans.add(copy(board));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1, n, ans);
                board[row][j] = '.';
            }
        }
    }

    boolean isSafe(char[][] B, int r, int c, int n) {
        // column
        for (int i = 0; i < r; i++) {
            if (B[i][c] == 'Q') return false;
        }

        // left diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (B[i][j] == 'Q') return false;
        }

        // right diagonal
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (B[i][j] == 'Q') return false;
        }

        return true;
    }

    char[][] copy(char[][] board) {
        char[][] newB = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                newB[i][j] = board[i][j];
            }
        }
        return newB;
    }
}
