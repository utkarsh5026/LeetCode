package backtracking.medium;

// https://leetcode.com/problems/word-search/description/
// 79. Word Search
class Solution {

    private static final int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }

    boolean find(int i, int j, int wordIdx, char[][] board, String word) {
        if (wordIdx >= word.length()) {
            return true;
        }

        boolean outside = i < 0 || i >= board.length || j < 0 || j >= board[0].length;

        if (outside || board[i][j] != word.charAt(wordIdx))
            return false;

        char curr = board[i][j];
        board[i][j] = '.';
        for (int[] dir : directions) {
            int di = dir[0];
            int dj = dir[1];

            boolean found = find(i + di, j + dj, wordIdx + 1, board, word);

            if (found)
                return true;
        }

        board[i][j] = curr;
        return false;
    }
}
