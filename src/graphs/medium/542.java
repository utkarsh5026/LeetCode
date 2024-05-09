package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/01-matrix/description/
// 542. 01 Matrix
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0)
                    result[i][j] = 0;
                else
                    result[i][j] = -1;
            }
        }

        bfs(result);
        return result;
    }

    private void bfs(int[][] result) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] != 0)
                    continue;
                int[] cord = new int[] { i, j };
                queue.add(cord);
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] cord = queue.pollFirst();
            int x = cord[0];
            int y = cord[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                boolean outside = newX < 0 || newX >= result.length || newY < 0 || newY >= result[0].length;

                if (outside || result[newX][newY] != -1)
                    continue;

                if (result[newX][newY] == -1) {
                    result[newX][newY] = result[x][y] + 1;
                    queue.add(new int[] { newX, newY });
                }
            }

        }
    }
}
