package graphs.medium;

import java.util.*;
// https:// leetcode.com/problems/find-eventual-safe-states/description/
// 802. Find Eventual Safe States

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int nbr : graph[i]) {
                reverseGraph.get(nbr).add(i);
                indegree[i]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            safeNodes.add(node);
            for (int nbr : reverseGraph.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

}
