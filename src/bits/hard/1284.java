package bits.hard;

import java.util.*;

// https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/description/
// 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix
class Solution {

    public int minFlips(int[][] mat) {
        int m = mat.length; // Number of rows
        int n = mat[0].length; // Number of columns

        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    start |= (1 << (i * n + j));
                }
            }
        }
        if (start == 0)
            return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int steps = 0;

        int[][] dirs = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int x = 0; x < m; x++) {
                    for (int y = 0; y < n; y++) {
                        int next = curr;
                        for (int[] dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                next ^= (1 << (nx * n + ny));
                            }
                        }

                        // If we've reached the zero state, return the number of steps
                        if (next == 0)
                            return steps;

                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }

        return -1;
    }
}