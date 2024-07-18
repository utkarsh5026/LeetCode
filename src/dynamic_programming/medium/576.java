package dynamic_programming.medium;

import java.util.Arrays;

// https://leetcode.com/problems/out-of-boundary-paths/description/
// 576. Out of Boundary Paths
class Solution {
    private static final int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (int) (solve(startRow, startColumn, maxMove, m, n, dp) % MOD);
    }

    long solve(int x, int y, int moves, int rows, int cols, long[][][] dp) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) return 1;
        if (moves == 0) return 0;
        if (dp[x][y][moves] != -1) return dp[x][y][moves];

        dp[x][y][moves] = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            dp[x][y][moves] += solve(x + dir[0], y + dir[1], moves - 1, rows, cols, dp);
            dp[x][y][moves] %= MOD;
        }

        return dp[x][y][moves];
    }
}