package arrays.medium;

// https://leetcode.com/problems/battleships-in-a-board/description/
// 419. Battleships in a Boards
class Solution {
    public int countBattleships(char[][] board) {
        int battleShips = 0;

        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    dfs(i, j, board, rows, cols);
                    battleShips++;
                }
            }
        }
        return battleShips;
    }

    void dfs(int x, int y, char[][] board, int rows, int cols) {
        boolean out = x < 0 || x >= rows || y < 0 || y >= cols;
        if (out || board[x][y] == '.')
            return;

        board[x][y] = '.';

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : directions) {
            dfs(x + dir[0], y + dir[1], board, rows, cols);
        }
    }
}
