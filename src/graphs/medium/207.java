package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/course-schedule/description
// 207. Course Schedule
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = makeGraph(prerequisites, numCourses);
        return doesNotContainCycle(graph);
    }

    private Map<Integer, List<Integer>> makeGraph(int[][] prerequisites, int numCourses) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private boolean doesNotContainCycle(Map<Integer, List<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.fill(indegree, 0);

        for (int i = 0; i < graph.size(); i++) {
            List<Integer> nbrs = graph.get(i);

            for (int nbr : nbrs) {
                indegree[nbr]++;
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int visited = 0;

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            visited += 1;

            for (int nbr : graph.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0)
                    queue.add(nbr);
            }
        }

        return visited == graph.size();
    }
}
