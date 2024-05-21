package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/unique-paths/description/
// 62. Unique Paths
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, dp, m, n);
    }

    int solve(int i, int j, int[][] dp, int rows, int cols) {
        boolean outside = i >= rows || j >= cols;

        if (outside)
            return 0;

        if (i == rows - 1 && j == cols - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int rightPaths = solve(i + 1, j, dp, rows, cols);
        int downPaths = solve(i, j + 1, dp, rows, cols);

        dp[i][j] = rightPaths + downPaths;
        return dp[i][j];
    }

}
