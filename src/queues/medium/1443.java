package queues.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
// 1443. Minimum Time to Collect All Apples in a Tree
class Solution {

    int time;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, graph, hasApple, new HashSet<>());
        return time;
    }

    boolean dfs(int node, List<List<Integer>> graph, List<Boolean> containsApple, Set<Integer> visited) {
        visited.add(node);
        boolean appleFound = containsApple.get(node);

        for (int nbr : graph.get(node)) {
            if (visited.contains(nbr))
                continue;

            boolean appleInPath = dfs(nbr, graph, containsApple, visited);
            if (appleInPath)
                time += 2;

            appleFound |= appleInPath;
        }

        return appleFound;
    }
}