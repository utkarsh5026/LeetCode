package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-path-sum/description/
// 64. Minimum Path Sum
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(grid, 0, 0, dp, rows, cols);
    }

    int solve(int[][] grid, int i, int j, int[][] dp, int rows, int cols) {

        boolean outside = i >= rows || j >= cols;
        if (outside)
            return Integer.MAX_VALUE;

        boolean reachedEnd = i == rows - 1 && j == cols - 1;
        if (reachedEnd)
            return grid[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int downPathSum = solve(grid, i, j + 1, dp, rows, cols);
        int rightPathSum = solve(grid, i + 1, j, dp, rows, cols);

        int currentMinSum = grid[i][j] + Math.min(downPathSum, rightPathSum);

        dp[i][j] = currentMinSum;
        return currentMinSum;
    }
}
