package graphs.medium;

// https://leetcode.com/problems/number-of-enclaves/description/?
// 1020. Number of Enclaves
class Solution {
    public int numEnclaves(int[][] grid) {
        visitEveryNodeAtBorder(grid);
        return countOnesLeft(grid);
    }

    private void dfs(int x, int y, int[][] grid) {
        boolean outside = x < 0 || x >= grid.length || y < 0 || y >= grid.length;

        if (outside || grid[x][y] == 0)
            return;
        grid[x][y] = 0;

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];
            dfs(x + dx, y + dy, grid);
        }
    }

    private void visitEveryNodeAtBorder(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                boolean isBorder = (i == 0 || i == rows - 1) || (j == 0 || j == cols - 1);
                if (isBorder && grid[i][j] == 1)
                    dfs(i, j, grid);
            }
        }
    }

    private int countOnesLeft(int[][] grid) {
        int ones = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    ones++;
            }
        }
        return ones;
    }
}