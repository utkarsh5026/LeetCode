package arrays.medium;

//https://leetcode.com/problems/valid-sudoku/description/
// 36. Valid Sudoku
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board) && isValidColumns(board) && isValidSubgrids(board);
    }

    private boolean isValidRows(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (!isValidSet(board[row])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumns(char[][] board) {
        for (int col = 0; col < 9; col++) {
            char[] column = new char[9];
            for (int row = 0; row < 9; row++) {
                column[row] = board[row][col];
            }
            if (!isValidSet(column)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSubgrids(char[][] board) {
        for (int rowStart = 0; rowStart < 9; rowStart += 3) {
            for (int colStart = 0; colStart < 9; colStart += 3) {
                char[] subgrid = new char[9];
                int index = 0;
                for (int row = rowStart; row < rowStart + 3; row++) {
                    for (int col = colStart; col < colStart + 3; col++) {
                        subgrid[index++] = board[row][col];
                    }
                }
                if (!isValidSet(subgrid)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSet(char[] set) {
        boolean[] seen = new boolean[10];
        for (char c : set) {
            if (c != '.') {
                int num = c - '0';
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        return true;
    }
}
