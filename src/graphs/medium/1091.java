package graphs.medium;

// https://leetcode.com/problems/shortest-path-with-alternating-colors/description/
// 1129. Shortest Path with Alternating Colors
import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 },
            { -1, 1 }, { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (isStartOrEndBlocked(grid))
            return -1;

        Deque<int[]> pathQueue = new ArrayDeque<>();
        pathQueue.add(new int[] { 0, 0 });

        int distance = 1;
        while (!pathQueue.isEmpty()) {
            int nodes = pathQueue.size();

            for (int i = 0; i < nodes; i++) {
                int[] current = pathQueue.pollFirst();

                if (isEndOfGrid(current, grid))
                    return distance;

                exploreNeighbors(current, grid, pathQueue);
            }
            distance++;
        }
        return -1;
    }

    private boolean isStartOrEndBlocked(int[][] grid) {
        return grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1;
    }

    private boolean isEndOfGrid(int[] current, int[][] grid) {
        return current[0] == grid.length - 1 && current[1] == grid[0].length - 1;
    }

    private void exploreNeighbors(int[] current, int[][] grid, Deque<int[]> pathQueue) {
        for (int[] direction : DIRECTIONS) {
            int newX = current[0] + direction[0];
            int newY = current[1] + direction[1];

            if (isInBoundsAndUnblocked(newX, newY, grid)) {
                pathQueue.add(new int[] { newX, newY });
                grid[newX][newY] = 1; // Mark as visited
            }
        }
    }

    private boolean isInBoundsAndUnblocked(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0;
    }
}