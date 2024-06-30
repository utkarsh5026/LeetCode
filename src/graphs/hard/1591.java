package graphs.hard;

import java.util.*;

// https://leetcode.com/problems/strange-printer-ii/description/
// 1591. Strange Printer II
class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int maxColor = 0;

        // Find the maximum color value in the grid
        for (int[] row : targetGrid) {
            for (int color : row) {
                maxColor = Math.max(maxColor, color);
            }
        }

        // Step 1: Find bounds of each color
        int[][] bounds = new int[maxColor + 1][4];
        for (int i = 1; i <= maxColor; i++) {
            Arrays.fill(bounds[i], Integer.MAX_VALUE);
            bounds[i][1] = Integer.MIN_VALUE;
            bounds[i][3] = Integer.MIN_VALUE;
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int color = targetGrid[r][c];
                bounds[color][0] = Math.min(bounds[color][0], r);
                bounds[color][1] = Math.max(bounds[color][1], r);
                bounds[color][2] = Math.min(bounds[color][2], c);
                bounds[color][3] = Math.max(bounds[color][3], c);
            }
        }

        // Step 2: Build dependency graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[maxColor + 1];

        for (int color = 1; color <= maxColor; color++) {
            if (bounds[color][0] == Integer.MAX_VALUE) {
                continue;
            }
            int minRow = bounds[color][0], maxRow = bounds[color][1];
            int minCol = bounds[color][2], maxCol = bounds[color][3];
            for (int r = minRow; r <= maxRow; r++) {
                for (int c = minCol; c <= maxCol; c++) {
                    if (targetGrid[r][c] != color) {
                        int innerColor = targetGrid[r][c];
                        if (!graph.containsKey(innerColor)) {
                            graph.put(innerColor, new ArrayList<>());
                        }
                        if (!graph.get(innerColor).contains(color)) {
                            graph.get(innerColor).add(color);
                            indegree[color]++;
                        }
                    }
                }
            }
        }

        // Step 3: Topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int color = 1; color <= maxColor; color++) {
            if (indegree[color] == 0) {
                queue.add(color);
            }
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            int color = queue.poll();
            processed++;
            if (graph.containsKey(color)) {
                for (int nextColor : graph.get(color)) {
                    indegree[nextColor]--;
                    if (indegree[nextColor] == 0) {
                        queue.add(nextColor);
                    }
                }
            }
        }

        return processed == maxColor;
    }
}
