package graphs.easy;

// https://leetcode.com/problems/island-perimeter/description/
// 463. Island Perimeter
class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return dfs(i, j, grid);
            }
        }
        return 0;
    }

    private int dfs(int x, int y, int[][] grid) {
        boolean outside = x < 0 || y < 0 || x >= grid.length || y >= grid[0].length;
        if (outside || grid[x][y] == 0)
            return 1;

        if (grid[x][y] == -1)
            return 0;
        grid[x][y] = -1;
        int perimeter = 0;

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];

            perimeter += dfs(x + dx, y + dy, grid);
        }
        return perimeter;
    }
}