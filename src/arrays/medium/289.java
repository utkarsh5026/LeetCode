package arrays.medium;

// https://leetcode.com/problems/game-of-life/description/
// 289. Game of Life
class Solution {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] nextState = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = board[i][j];
                int livePeople = getLive(i, j, board);

                if (curr == 0 && livePeople == 3) {
                    nextState[i][j] = 1;
                } else if (curr == 1 && (livePeople == 2 || livePeople == 3)) {
                    nextState[i][j] = 1;
                } else {
                    nextState[i][j] = 0;
                }
            }
        }

        // Update the original board with the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextState[i][j];
            }
        }
    }

    int getLive(int x, int y, int[][] board) {
        int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        int livePeople = 0;
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                livePeople += board[nx][ny];
            }
        }
        return livePeople;
    }

}