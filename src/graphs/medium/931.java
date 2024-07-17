package graphs.medium;

import java.util.*;

// 931. Minimum Falling Path Sum
// https://leetcode.com/problems/minimum-falling-path-sum/description/
class Solution {
    public int minFallingPathSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if (m == 1 || n == 1)
            return mat[0][0];

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < mat.length; ++i) {
            ans = Math.min(ans, minFallingPathSum(mat, 0, i, dp));
        }

        return ans;
    }

    private int minFallingPathSum(int[][] mat, int row, int col, int[][] dp) {
        int m = mat.length;
        int n = mat[0].length;

        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

        if (row == m - 1)
            return dp[row][col] = mat[row][col];

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (col > 0)
            left = minFallingPathSum(mat, row + 1, col - 1, dp);

        int straight = minFallingPathSum(mat, row + 1, col, dp);

        if (col < n - 1)
            right = minFallingPathSum(mat, row + 1, col + 1, dp);

        dp[row][col] = Math.min(left, Math.min(straight, right)) + mat[row][col];

        return dp[row][col];
    }
}
