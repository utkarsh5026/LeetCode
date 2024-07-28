package graphs.medium;

// https://leetcode.com/problems/count-servers-that-communicate/description/
// 1267. Count Servers that Communicate
class Solution {
    private int m;
    private int n;
    private int[][] grid;
    private boolean[][] visited;

    public int countServers(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int groupSize = dfs(i, j);
                    if (groupSize > 1) {
                        count += groupSize;
                    }
                }
            }
        }

        return count;
    }

    private int dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int size = 1;

        // Check same row
        for (int j = 0; j < n; j++) {
            if (j != col) {
                size += dfs(row, j);
            }
        }

        // Check same column
        for (int i = 0; i < m; i++) {
            if (i != row) {
                size += dfs(i, col);
            }
        }

        return size;
    }
}
