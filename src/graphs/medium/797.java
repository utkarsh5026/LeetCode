package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/all-paths-from-source-to-target/description/
// 797. All Paths From Source to Target
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        findPaths(0, graph.length - 1, new ArrayList<>(Arrays.asList(0)), paths, visited, graph);
        return paths;
    }

    private void findPaths(int node, int target, List<Integer> path, List<List<Integer>> paths, boolean[] visited,
            int[][] graph) {
        if (node == target) {
            List<Integer> copy = new ArrayList<>(path);
            paths.add(copy);
            return;
        }

        int[] nbrs = graph[node];

        for (int nbr : nbrs) {
            if (visited[nbr])
                continue;

            visited[nbr] = true;
            path.add(nbr);

            findPaths(nbr, target, path, paths, visited, graph);

            visited[nbr] = false;
            path.remove(path.size() - 1);
        }
    }
}