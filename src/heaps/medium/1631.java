package heaps.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/path-with-minimum-effort/description/
// 1631. Path With Minimum Effort
class Solution {

    class CordEffort {
        int effort;
        int x;
        int y;

        public CordEffort(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        PriorityQueue<CordEffort> minHeap = new PriorityQueue<>((a, b) -> a.effort - b.effort);

        minHeap.add(new CordEffort(0, 0, 0));

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!minHeap.isEmpty()) {
            CordEffort currEffort = minHeap.poll();
            if (currEffort.x == rows - 1 && currEffort.y == cols - 1)
                return currEffort.effort;

            for (int[] dir : directions) {
                int nx = currEffort.x + dir[0];
                int ny = currEffort.y + dir[1];

                boolean outside = nx < 0 || nx >= rows || ny < 0 || ny >= cols;

                if (outside)
                    continue;

                int nextEffort = Math.max(currEffort.effort,
                        Math.abs(heights[nx][ny] - heights[currEffort.x][currEffort.y]));

                if (nextEffort < effort[nx][ny]) {
                    effort[nx][ny] = nextEffort;
                    minHeap.add(new CordEffort(nx, ny, nextEffort));
                }
            }
        }

        return effort[rows - 1][cols - 1];
    }
}