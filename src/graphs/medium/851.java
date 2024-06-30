package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/loud-and-rich/description/
// 851. Loud and Rich
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> graph = makeGraph(quiet.length, richer);
        List<Set<Integer>> ancestors = getAncestors(graph);

        int[] result = new int[quiet.length];

        Arrays.fill(result, Integer.MAX_VALUE);
        for (int node = 0; node < result.length; node++) {
            Set<Integer> moreMoney = ancestors.get(node);
            List<Integer> quietest = new ArrayList<>(moreMoney);
            quietest.add(node);

            result[node] = node;
            for (int rich : quietest) {
                if (quiet[rich] < quiet[result[node]])
                    result[node] = rich;
            }
        }

        return result;
    }

    private List<List<Integer>> makeGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

    private List<Set<Integer>> getAncestors(List<List<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        Arrays.fill(indegree, 0);

        for (List<Integer> nbrs : graph) {
            for (int nbr : nbrs) {
                indegree[nbr]++;
            }
        }

        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            ancestors.add(new HashSet<>());
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int parent = queue.pollFirst();

            for (int nbr : graph.get(parent)) {
                ancestors.get(nbr).add(parent);
                ancestors.get(nbr).addAll(ancestors.get(parent));
                indegree[nbr]--;

                if (indegree[nbr] == 0)
                    queue.add(nbr);
            }
        }

        return ancestors;

    }

}