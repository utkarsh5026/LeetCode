package queues.medium;

// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/
// 2658. Maximum Number of Fish in a Grid
class Solution {
    public int findMaxFish(int[][] grid) {
        int maxFish = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0)
                    maxFish = Math.max(dfs(i, j, grid, rows, cols), maxFish);
            }
        }

        return maxFish == Integer.MIN_VALUE ? 0 : maxFish;
    }

    int dfs(int x, int y, int[][] grid, int rows, int cols) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0)
            return 0;

        int fish = grid[x][y];
        grid[x][y] = 0;

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] dir : directions) {
            int xdx = x + dir[0];
            int ydy = y + dir[1];

            fish += dfs(xdx, ydy, grid, rows, cols);
        }
        return fish;
    }
}