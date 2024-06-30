package graphs.hard;

import java.util.*;

// https://leetcode.com/problems/build-a-matrix-with-conditions/description/
// 2392. Build a Matrix With Conditions
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowPositions = topologicalSort(k, rowConditions);
        int[] colPositions = topologicalSort(k, colConditions);

        // If either sorting fails (detects a cycle), return empty matrix
        if (rowPositions.length == 0 || colPositions.length == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[k][k];

        Point[] points = new Point[k + 1];
        for (int i = 1; i <= k; i++) {
            if (rowPositions[i] == -1 || colPositions[i] == -1) {
                return new int[0][0];
            }
            points[i] = new Point(rowPositions[i], colPositions[i]);
        }

        for (int i = 1; i <= k; i++) {
            Point p = points[i];
            if (matrix[p.x][p.y] != 0) {
                return new int[0][0];
            }
            matrix[p.x][p.y] = i;
        }

        return matrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[k + 1];
        int[] positions = new int[k + 1];
        Arrays.fill(positions, -1);

        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            positions[current] = idx++;
            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (idx != k)
            return new int[0];

        return positions;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
