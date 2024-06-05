package arrays.easy;

// https://leetcode.com/problems/largest-local-values-in-a-matrix/description/
// 2373. Largest Local Values in a Matrix
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; ++i) {
            for (int j = 0; j < n - 2; ++j) {
                int maxVal = Integer.MIN_VALUE;
                for (int ii = i; ii < i + 3; ++ii) {
                    for (int jj = j; jj < j + 3; ++jj) {
                        maxVal = Math.max(maxVal, grid[ii][jj]);
                    }
                }
                result[i][j] = maxVal;
            }
        }
        return result;
    }
}