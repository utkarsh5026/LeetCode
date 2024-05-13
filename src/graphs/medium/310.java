package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-height-trees/description/
// 310. Minimum Height Trees
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return new ArrayList<>(Arrays.asList(0));
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        intialize(n, edges, graph, indegree);
        return topoSort(graph, indegree);
    }

    void intialize(int veritices, int[][] edges, List<List<Integer>> graph, int[] indegree) {
        Arrays.fill(indegree, 0);
        for (int i = 0; i < veritices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
            indegree[a]++;
            indegree[b]++;
        }
    }

    List<Integer> topoSort(List<List<Integer>> graph, int[] indegree) {
        Deque<Integer> leaves = new ArrayDeque<>();
        List<Integer> centerOfMass = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 1)
                leaves.add(i);
        }

        while (!leaves.isEmpty()) {
            int leafCount = leaves.size();
            centerOfMass.clear();

            for (int i = 0; i < leafCount; i++) {
                int leaf = leaves.pollFirst();
                centerOfMass.add(leaf);

                for (int nbr : graph.get(leaf)) {
                    indegree[nbr]--;
                    if (indegree[nbr] == 1)
                        leaves.add(nbr);
                }
            }
        }

        return centerOfMass;

    }
}