package graphs.hard;

import java.util.*;

// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/description/
// 2246. Longest Path With Different Adjacent Characters
class Solution {
    int longestPathValue = 1;

    public int longestPath(int[] parent, String s) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            int j = parent[i];
            adj.putIfAbsent(j, new LinkedList<>());
            adj.get(j).add(i);
        }

        dfs(0, adj, s);
        return longestPathValue;
    }

    public int dfs(int node, Map<Integer, List<Integer>> adj, String s) {
        // if the node is a leaf node, return 1
        if (!adj.containsKey(node))
            return 1;
        int max = 0;
        int secondMax = 0;
        // for each neighbor of the node
        for (int nbrNode : adj.get(node)) {
            int longestPathFromNbrNode = dfs(nbrNode, adj, s);
            if (s.charAt(node) == s.charAt(nbrNode))
                continue;

            if (longestPathFromNbrNode > max) {
                secondMax = max;
                max = longestPathFromNbrNode;
            } else if (longestPathFromNbrNode > secondMax) {
                secondMax = longestPathFromNbrNode;
            }
        }

        longestPathValue = Math.max(longestPathValue, max + secondMax + 1);
        return max + 1;
    }
}