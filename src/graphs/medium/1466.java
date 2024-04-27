package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description
// 1466. Reorder Routes to Make All Paths Lead to the City Zero
class Solution {

    int count = 0;

    public int minReorder(int cities, int[][] connections) {
        Map<Integer, List<Integer>> graph = makeGraph(connections, cities);
        boolean[] visited = new boolean[cities];
        Arrays.fill(visited, false);
        dfs(0, graph, visited);
        return count;
    }

    public Map<Integer, List<Integer>> makeGraph(int[][] connections, int cities) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < cities; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] connnection : connections) {
            int a = connnection[0];
            int b = connnection[1];
            graph.get(a).add(b);
            graph.get(b).add(-a);
        }
        return graph;
    }

    public void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        List<Integer> nbrs = graph.get(node);
        for (int nbr : nbrs) {
            if (visited[Math.abs(nbr)])
                continue;
            boolean isForwardEdge = nbr > 0;
            if (isForwardEdge)
                count++;
            dfs(Math.abs(nbr), graph, visited);
        }
    }
}