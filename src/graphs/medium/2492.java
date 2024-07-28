package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
// 2492. Minimum Score of a Path Between Two Cities
class Solution {
    private Map<Integer, List<int[]>> graph;
    private Set<Integer> visited;
    private int minScore;

    public int minScore(int n, int[][] roads) {
        // Initialize graph
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build the graph
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int distance = road[2];
            graph.get(a).add(new int[] { b, distance });
            graph.get(b).add(new int[] { a, distance });
        }

        // Initialize variables for DFS
        visited = new HashSet<>();
        minScore = Integer.MAX_VALUE;

        // Start DFS from city 1
        dfs(1);

        return minScore;
    }

    private void dfs(int city) {
        if (visited.contains(city)) {
            return;
        }
        visited.add(city);

        for (int[] neighbor : graph.get(city)) {
            int nextCity = neighbor[0];
            int distance = neighbor[1];
            minScore = Math.min(minScore, distance);
            dfs(nextCity);
        }
    }
}