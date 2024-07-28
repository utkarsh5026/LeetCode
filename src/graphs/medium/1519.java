package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/
// 1519. Number of Nodes in the Sub-Tree With the Same Label
class Solution {
    private List<List<Integer>> adj;
    private int[] result;
    private String labels;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // Initialize adjacency list
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the tree
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        this.labels = labels;
        result = new int[n];

        // Start DFS from root (node 0)
        dfs(0, -1);

        return result;
    }

    private int[] dfs(int node, int parent) {
        int[] count = new int[26]; // Count for each label (a-z)

        // Count the current node's label
        count[labels.charAt(node) - 'a']++;

        // Explore all children
        for (int child : adj.get(node)) {
            if (child != parent) {
                int[] childCount = dfs(child, node);
                // Aggregate counts from child
                for (int i = 0; i < 26; i++) {
                    count[i] += childCount[i];
                }
            }
        }

        // Set the result for current node
        result[node] = count[labels.charAt(node) - 'a'];

        return count;
    }

}