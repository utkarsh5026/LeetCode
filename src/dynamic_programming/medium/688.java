package dynamic_programming.medium;


// https://leetcode.com/problems/knight-probability-in-chessboard/description/
// 688. Knight Probability in Chessboard
class Solution {
    private static final int[][] DIRECTIONS = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public double knightProbability(int n, int k, int row, int column) {
        // Memoization array
        Double[][][] dp = new Double[k + 1][n][n];
        return solve(n, k, row, column, dp);
    }

    private double solve(int n, int k, int r, int c, Double[][][] dp) {
        // Base cases
        if (r < 0 || r >= n || c < 0 || c >= n) return 0.0;
        if (k == 0) return 1.0;

        // Check if result is already computed
        if (dp[k][r][c] != null) return dp[k][r][c];

        // Recursive computation
        double probability = 0.0;
        for (int[] dir : DIRECTIONS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            probability += solve(n, k - 1, newRow, newCol, dp) / 8.0;
        }

        // Store the result in memoization array
        dp[k][r][c] = probability;
        return probability;
    }


}
