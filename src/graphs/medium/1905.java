package graphs.medium;

// https://leetcode.com/problems/count-sub-islands/description/
// 1905. Count Sub Islands
class Solution {
    private int rows;
    private int cols;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rows = grid1.length;
        cols = grid1[0].length;
        int subIslandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    subIslandCount++;
                }

            }
        }

        return subIslandCount;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid2[x][y] == 0) {
            return true;
        }

        if (grid1[x][y] == 0) {
            return false;
        }

        grid2[x][y] = 0;
        boolean isSubIsland = true;

        isSubIsland &= dfs(grid1, grid2, x - 1, y);
        isSubIsland &= dfs(grid1, grid2, x + 1, y);
        isSubIsland &= dfs(grid1, grid2, x, y - 1);
        isSubIsland &= dfs(grid1, grid2, x, y + 1);

        return isSubIsland;
    }

}
