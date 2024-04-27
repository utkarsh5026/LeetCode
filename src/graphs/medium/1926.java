package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
// 1926. Nearest Exit from Entrance in Maze
class Solution {
    class Cord {
        int x;
        int y;
        int distFromEntrance;

        public Cord(int x, int y, int distFromEntrance) {
            this.x = x;
            this.y = y;
            this.distFromEntrance = distFromEntrance;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Cord> pathToExit = new ArrayDeque<>();
        int rows = maze.length;
        int cols = maze[0].length;

        pathToExit.add(new Cord(entrance[0], entrance[1], 0));
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pathToExit.isEmpty()) {
            Cord curr = pathToExit.poll();
            boolean isExit = curr.x == 0 || curr.x == rows - 1 || curr.y == 0 || curr.y == cols - 1;
            boolean isEntrance = curr.x == entrance[0] && curr.y == entrance[1];

            if (isExit && !isEntrance)
                return curr.distFromEntrance;

            for (int[] dir : directions) {
                int newX = curr.x + dir[0];
                int newY = curr.y + dir[1];

                boolean isOutside = newX < 0 || newX >= rows || newY < 0 || newY >= cols;
                if (isOutside || maze[newX][newY] == '+')
                    continue;

                maze[newX][newY] = '+';
                pathToExit.add(new Cord(newX, newY, curr.distFromEntrance + 1));
            }
        }
        return -1;
    }
}