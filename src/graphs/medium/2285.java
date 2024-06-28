package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/maximum-total-importance-of-roads/description/
// 2285. Maximum Total Importance of Roadss
class Solution {

    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        makeGraph(n, graph, roads);

        List<Integer> vertices = new ArrayList<>(graph.keySet());
        Collections.sort(vertices, (a, b) -> graph.get(a).size() - graph.get(b).size());
        Map<Integer, Integer> importance = new HashMap<>();
        for (int i = 0; i < vertices.size(); i++) {
            importance.put(vertices.get(i), i + 1);
        }

        long totalSum = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            totalSum += dfs(i, graph, importance, visited);
        }
        return totalSum;
    }

    void makeGraph(int n, Map<Integer, List<Integer>> graph, int[][] roads) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    long dfs(int node, Map<Integer, List<Integer>> graph, Map<Integer, Integer> importance, Set<String> visited) {
        long totalSum = importance.get(node);

        for (int nbr : graph.get(node)) {
            String connection = getConnectionHash(node, nbr);
            if (visited.contains(connection))
                continue;

            visited.add(connection);
            totalSum += dfs(nbr, graph, importance, visited);
        }
        return totalSum;
    }

    String getConnectionHash(int a, int b) {
        if (a < b)
            return a + "," + b;
        return b + "," + a;
    }

}
