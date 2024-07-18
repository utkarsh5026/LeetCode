package dynamic_programming.hard;

import java.util.Arrays;

// https://leetcode.com/problems/cherry-pickup-ii/description/
// 1463. Cherry Pickup II
class Solution {
    private int[][][] memo;
    private int rows;
    private int cols;
    private int[][] grid;

    public int cherryPickup(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        this.memo = new int[rows][cols][cols];

        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return dp(0, 0, cols - 1);
    }

    private int dp(int row, int col1, int col2) {
        if (row == rows) return 0;
        if (col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) return 0;

        if (memo[row][col1][col2] != -1) return memo[row][col1][col2];

        int result = grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }

        int max = 0;
        for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
            for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                max = Math.max(max, dp(row + 1, newCol1, newCol2));
            }
        }

        result += max;
        memo[row][col1][col2] = result;
        return result;
    }

}
