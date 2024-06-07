package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/
// 1743. Restore the Array From Adjacent Pairs
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        initializeGraph(adjacentPairs, graph);

        List<Integer> restored = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> connections : graph.entrySet()) {
            int node = connections.getKey();
            int nbrs = connections.getValue().size();

            if (nbrs == 1) {
                dfs(node, graph, new HashSet<>(), restored);
                break;
            }
        }
        return restored.stream().mapToInt(i -> i).toArray();
    }

    void initializeGraph(int[][] edges, Map<Integer, List<Integer>> graph) {
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.computeIfAbsent(a, nbrs -> new ArrayList<>());
            graph.computeIfAbsent(b, nbrs -> new ArrayList<>());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    void dfs(int root, Map<Integer, List<Integer>> graph, Set<Integer> visited, List<Integer> restored) {
        visited.add(root);
        restored.add(root);

        for (int nbr : graph.get(root)) {
            if (visited.contains(nbr))
                continue;

            dfs(nbr, graph, visited, restored);
        }
    }

}