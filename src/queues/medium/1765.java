package queues.medium;

import java.util.*;

// https://leetcode.com/problems/map-of-highest-peak/description/
// 1765. Map of Highest Peak
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] height = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        // Initialize heights and add water cells to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else {
                    height[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && height[nx][ny] > height[x][y] + 1) {
                    height[nx][ny] = height[x][y] + 1;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }

        return height;
    }
}