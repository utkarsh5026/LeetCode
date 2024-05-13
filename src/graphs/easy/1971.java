package graphs.easy;

import java.util.*;

// https://leetcode.com/problems/find-if-path-exists-in-graph/description/
// 1971. Find if Path Exists in Graph
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = buildGraph(edges, n);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        return dfs(source, destination, visited, graph);
    }

    Map<Integer, List<Integer>> buildGraph(int[][] edges, int vertices) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }

    boolean dfs(int node, int destination, boolean[] visited, Map<Integer, List<Integer>> graph) {
        if (node == destination)
            return true;

        visited[node] = true;
        for (int nbr : graph.get(node)) {
            if (visited[nbr])
                continue;

            boolean targetFound = dfs(nbr, destination, visited, graph);
            if (targetFound)
                return true;
        }
        return false;
    }
}
