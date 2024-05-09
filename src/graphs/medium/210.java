package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/description/
// 210. Course Schedule II
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = makeGraph(prerequisites, numCourses);
        return createScheduleUsingTopoSort(graph);
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

    private int[] createScheduleUsingTopoSort(Map<Integer, List<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < graph.size(); i++) {
            for (int nbr : graph.get(i)) {
                indegree[nbr]++;
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int[] schedule = new int[graph.size()];
        int visited = 0;

        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            schedule[visited++] = node;

            for (int nbr : graph.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0)
                    queue.add(nbr);
            }
        }

        return visited == graph.size() ? schedule : new int[] {};
    }
}