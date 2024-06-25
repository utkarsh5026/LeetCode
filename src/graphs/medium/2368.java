package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/reachable-nodes-with-restrictions/description/
// 2368. Reachable Nodes With Restrictionss
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrictedSet = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int node : restricted) {
            restrictedSet.add(node);
        }

        makeGraph(n, graph, edges);
        return countNodesToVistit(0, null, restrictedSet, restrictedSet);
    }

    void makeGraph(int nodes, List<List<Integer>> graph, int[][] connections) {
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] conn : connections) {
            int a = conn[0];
            int b = conn[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    int countNodesToVistit(int root, List<List<Integer>> graph, Set<Integer> restricted, Set<Integer> visited) {
        if (restricted.contains(root))
            return 0;

        visited.add(root);
        int canVistit = 1;

        for (int nbr : graph.get(root)) {
            if (visited.contains(nbr) || restricted.contains(nbr))
                continue;

            canVistit += countNodesToVistit(nbr, graph, restricted, visited);
        }
        return canVistit;
    }
}
