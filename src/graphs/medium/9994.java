package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/rotting-oranges/description/
// 994. Rotting Oranges
class Solution {
    class Cord {
        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Cord> rotten = new ArrayDeque<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int current = grid[i][j];
                if (current == 2)
                    rotten.add(new Cord(i, j));
                if (current == 1)
                    freshCount++;
            }
        }

        if (freshCount == 0)
            return 0;
        return calculateTimeElapsed(rotten, freshCount, grid);
    }

    private int calculateTimeElapsed(Queue<Cord> rotten, int freshOrangeCount, int[][] grid) {
        int timeElapsed = 0;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int rows = grid.length;
        int cols = grid[0].length;

        while (!rotten.isEmpty()) {
            int rottenOranges = rotten.size();
            timeElapsed++;
            for (int i = 0; i < rottenOranges; i++) {
                Cord rottenOrange = rotten.poll();

                for (int[] dir : directions) {
                    int x = rottenOrange.x + dir[0];
                    int y = rottenOrange.y + dir[1];

                    boolean outside = x < 0 || x >= rows || y < 0 || y >= cols;
                    if (outside || grid[x][y] != 1)
                        continue;

                    grid[x][y] = 2;
                    rotten.add(new Cord(x, y));
                    freshOrangeCount--;
                }
            }
        }

        return freshOrangeCount == 0 ? timeElapsed - 1 : -1;
    }
}