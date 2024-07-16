package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
// 1277. Count Square Submatrices with All Ones
class Solution {
    private int[][] matrix;
    private int[][] memo;
    private int m;
    private int n;

    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.memo = new int[m][n];

        // Initialize memo with -1 to indicate uncalculated states
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += dfs(i, j);
            }
        }

        return count;
    }

    private int dfs(int i, int j) {
        if (i >= m || j >= n || matrix[i][j] == 0) {
            return 0;
        }

        // Check if we've already calculated this state
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Recursive case
        int right = dfs(i, j + 1);
        int down = dfs(i + 1, j);
        int diagonal = dfs(i + 1, j + 1);

        memo[i][j] = 1 + Math.min(Math.min(right, down), diagonal);

        return memo[i][j];
    }
}
