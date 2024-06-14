package greedy.medium;

// https:// leetcode.com/problems/max-increase-to-keep-city-skyline/description/
// 807. Max Increase to Keep City Skyline
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxRowHeights = new int[n];
        int[] maxColHeights = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRowHeights[i] = Math.max(maxRowHeights[i], grid[i][j]);
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                maxColHeights[j] = Math.max(maxColHeights[j], grid[i][j]);
            }
        }

        int totalIncrease = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int allowedHeight = Math.min(maxRowHeights[i], maxColHeights[j]);
                totalIncrease += allowedHeight - grid[i][j];
            }
        }

        return totalIncrease;
    }
}
