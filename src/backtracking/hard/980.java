package backtracking.hard;

// https://leetcode.com/problems/unique-paths-iii/description/
// 980. Unique Paths III
class Solution {
    private int m;
    private int n;
    private int emptySquares;
    private int[][] grid;
    private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int startX = 0;
        int startY = 0;
        emptySquares = 0;

        // Find the starting position and count empty squares
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    emptySquares++;
                }
            }
        }

        // Add 1 to emptySquares to account for the starting square
        return dfs(startX, startY, emptySquares + 1);
    }

    private int dfs(int i, int j, int remainingSquares) {
        // Check if out of bounds or obstacle
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return 0;
        }

        // Check if reached the end
        if (grid[i][j] == 2) {
            return remainingSquares == 0 ? 1 : 0;
        }

        // Mark current square as visited
        int temp = grid[i][j];
        grid[i][j] = -1;
        remainingSquares--;

        int paths = 0;
        // Explore all four directions
        for (int[] dir : directions) {
            paths += dfs(i + dir[0], j + dir[1], remainingSquares);
        }

        // Backtrack
        grid[i][j] = temp;

        return paths;
    }
}