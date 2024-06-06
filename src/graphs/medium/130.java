package graphs.medium;

// https://leetcode.com/problems/surrounded-regions/description/
// 130. Surrounded Regions
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                markBorderConnected(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                markBorderConnected(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                markBorderConnected(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                markBorderConnected(board, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markBorderConnected(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';

        markBorderConnected(board, i - 1, j);
        markBorderConnected(board, i + 1, j);
        markBorderConnected(board, i, j - 1);
        markBorderConnected(board, i, j + 1);
    }
}
