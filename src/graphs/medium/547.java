package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/number-of-provinces/description/
// 547. Number of Provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = makeGraph(isConnected);
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i])
                continue;
            this.dfs(i, graph, visited);
            provinces++;
        }
        return provinces;

    }

    public void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        List<Integer> nbrs = graph.get(node);

        for (int nbr : nbrs) {
            if (!visited[nbr])
                this.dfs(nbr, graph, visited);
        }
    }

    public Map<Integer, List<Integer>> makeGraph(int[][] connected) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < connected.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < connected.length; i++) {
            for (int j = 0; j < connected[0].length; j++) {
                if (connected[i][j] == 1)
                    graph.get(i).add(j);
            }
        }
        return graph;
    }
}