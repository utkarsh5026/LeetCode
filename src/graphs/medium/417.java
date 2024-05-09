package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/pacific-atlantic-water-flow/description/
// 417. Pacific Atlantic Water Flow
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return result;

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacificVisited, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlanticVisited, Integer.MIN_VALUE, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacificVisited, Integer.MIN_VALUE, 0, j);
            dfs(heights, atlanticVisited, Integer.MIN_VALUE, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int previousHeight, int x, int y) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y]
                || heights[x][y] < previousHeight)
            return;

        visited[x][y] = true;

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            dfs(heights, visited, heights[x][y], newX, newY);
        }
    }
}
