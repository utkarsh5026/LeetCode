package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/count-the-number-of-complete-components/description/
// 2685. Count the Number of Complete Components
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = makeGraph(n, edges);
        Set<Integer> visited = new HashSet<>();
        int connected = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                List<Integer> nodes = new ArrayList<>();
                dfs(i, graph, visited, nodes);
                if (isComplete(nodes, graph))
                    connected++;
            }
        }
        return connected;
    }

    List<List<Integer>> makeGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return graph;
    }

    void dfs(int node, List<List<Integer>> graph, Set<Integer> visited, List<Integer> nodes) {
        visited.add(node);
        nodes.add(node);
        for (int nbr : graph.get(node)) {
            if (!visited.contains(nbr))
                dfs(nbr, graph, visited, nodes);
        }
    }

    boolean isComplete(List<Integer> nodes, List<List<Integer>> graph) {
        int vertices = nodes.size();
        int edges = 0;

        for (int node : nodes) {
            edges += graph.get(node).size();
        }

        edges = edges / 2;
        return edges == (vertices * (vertices - 1) / 2);
    }

}