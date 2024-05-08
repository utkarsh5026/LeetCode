package graphs.medium;

// https://leetcode.com/problems/max-area-of-island/description/
// 695. Max Area of Island
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;

                maxArea = Math.max(maxArea, calculateAreaUsingDfs(i, j, grid));
            }
        }
        return maxArea;
    }

    private int calculateAreaUsingDfs(int x, int y, int[][] grid) {
        boolean outside = x < 0 || x >= grid.length || y < 0 || y >= grid.length;

        grid[x][y] = 0;

        if (outside || grid[x][y] == 1)
            return 0;

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int area = 0;
        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            area += calculateAreaUsingDfs(x + dx, y + dy, grid);
        }
        return area;
    }
}