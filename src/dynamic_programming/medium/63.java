package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/unique-paths-ii/description/
// 63. Unique Paths II
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, obstacleGrid, dp, rows, cols);
    }

    int solve(int i, int j, int[][] grid, int[][] dp, int rows, int cols) {
        boolean outside = i >= rows || j >= cols;

        if (outside || grid[i][j] == 1)
            return 0;

        if (i == rows - 1 && j == cols - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int rightPaths = solve(i + 1, j, grid, dp, rows, cols);
        int downPaths = solve(i, j + 1, grid, dp, rows, cols);

        dp[i][j] = rightPaths + downPaths;
        return dp[i][j];
    }
}