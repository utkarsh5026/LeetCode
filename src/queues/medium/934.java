package queues.medium;

import java.util.*;

// https://leetcode.com/problems/shortest-bridge/description/
// 934. Shortest Bridge
class Solution {
    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        List<int[]> areaOne = new ArrayList<>();
        boolean foundIsland = false;
        for (int i = 0; i < rows && !foundIsland; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    markArea(i, j, grid, rows, cols, areaOne);
                    foundIsland = true;
                    break;
                }
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        for (int[] cell : areaOne) {
            int x = cell[0];
            int y = cell[1];
            queue.add(new int[] { x, y, 0 }); // x, y, distance
            visited[x][y] = true;
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                    if (grid[nx][ny] == 1) {
                        return distance;
                    }
                    queue.add(new int[] { nx, ny, distance + 1 });
                    visited[nx][ny] = true;
                }
            }
        }

        return -1; // No bridge found
    }

    void markArea(int x, int y, int[][] grid, int rows, int cols, List<int[]> area) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != 1) {
            return;
        }

        grid[x][y] = 2;
        area.add(new int[] { x, y });

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            markArea(nx, ny, grid, rows, cols, area);
        }
    }
}