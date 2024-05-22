package dynamic_programming.medium;

// https://leetcode.com/problems/maximal-square/description/
// 221. Maximal Square
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        int maxSideLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    maxSideLength = Math.max(maxSideLength, maximalSquareHelper(matrix, i, j, memo));
                }
            }
        }

        return maxSideLength * maxSideLength;
    }

    int maximalSquareHelper(char[][] matrix, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (matrix[i][j] == '0') {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int left = maximalSquareHelper(matrix, i, j - 1, memo);
        int up = maximalSquareHelper(matrix, i - 1, j, memo);
        int diag = maximalSquareHelper(matrix, i - 1, j - 1, memo);

        memo[i][j] = Math.min(Math.min(left, up), diag) + 1;
        return memo[i][j];
    }
}