package graphs.medium;

// https://leetcode.com/problems/number-of-closed-islands/description/
// 1254. Number of Closed Islands
class Solution {
    public int closedIsland(int[][] grid) {
        visitAllIslandsAtBorder(grid);
        return getClosedIslands(grid);
    }

    private void dfs(int x, int y, int[][] grid, int rows, int cols) {

        boolean outside = x < 0 || x >= rows || y < 0 || y >= cols;
        if (outside || grid[x][y] == 1)
            return;

        grid[x][y] = 1;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            dfs(x + dx, y + dy, grid, rows, cols);
        }
    }

    private void visitAllIslandsAtBorder(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isBorder = i == 0 || i == rows - 1 || j == 0 || j == cols - 1;

                if (isBorder && grid[i][j] == 0)
                    dfs(i, j, grid, rows, cols);
            }
        }
    }

    private int getClosedIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int closedIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    continue;
                dfs(i, j, grid, rows, cols);
                closedIslands++;
            }
        }

        return closedIslands;
    }

}