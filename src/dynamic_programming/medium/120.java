package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/triangle/description/
// 120. Triangle
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();

        int[][] dp = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findMinimumPath(triangle, 0, 0, dp);
    }

    int findMinimumPath(List<List<Integer>> triangle, int row, int col, int[][] memo) {

        if (row == triangle.size() - 1)
            return triangle.get(row).get(col);

        if (memo[row][col] != -1)
            return memo[row][col];

        int curr = triangle.get(row).get(col);
        int leftPathSum = findMinimumPath(triangle, row + 1, col, memo);
        int rightPathSum = findMinimumPath(triangle, row + 1, col + 1, memo);

        int currentPathSum = curr + Math.min(leftPathSum, rightPathSum);
        memo[row][col] = currentPathSum;
        return currentPathSum;
    }
}