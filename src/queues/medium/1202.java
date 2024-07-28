package queues.medium;

import java.util.*;

// https://leetcode.com/problems/smallest-string-with-swaps/description/
// 1202. Smallest String With Swaps
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> pair : pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                List<Character> chars = new ArrayList<>();

                // BFS to find connected component
                bfs(i, graph, visited, component, chars, s);

                // Sort the characters and indices
                Collections.sort(component);
                Collections.sort(chars);

                // Place sorted characters back into result
                for (int j = 0; j < component.size(); j++) {
                    result[component.get(j)] = chars.get(j);
                }
            }
        }

        return new String(result);
    }

    private void bfs(int start, Map<Integer, List<Integer>> graph, boolean[] visited,
            List<Integer> component, List<Character> chars, String s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);
            chars.add(s.charAt(node));

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
}