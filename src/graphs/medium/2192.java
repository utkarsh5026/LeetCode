package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/
// 2192. All Ancestors of a Node in a Directed Acyclic Graph
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ancestors.add(new TreeSet<>());
        }

        int[] indegree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : ancestors) {
            result.add(new ArrayList<>(set));
        }

        return result;
    }

}