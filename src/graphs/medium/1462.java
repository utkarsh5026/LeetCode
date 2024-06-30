package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/course-schedule-iv/description/
// 1462. Course Schedule IV
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] preq : prerequisites) {
            graph.get(preq[0]).add(preq[1]);
        }

        List<Set<Integer>> ancestors = getAncestors(graph);
        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            int before = query[0];
            int after = query[1];

            boolean isPreq = ancestors.get(after).contains(before);
            result.add(isPreq);
        }

        return result;
    }

    List<Set<Integer>> getAncestors(List<List<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        Arrays.fill(indegree, 0);

        for (List<Integer> nbrs : graph) {
            for (int nbr : nbrs) {
                indegree[nbr]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            ancestors.add(new HashSet<>());
        }

        while (!queue.isEmpty()) {
            int parent = queue.pollFirst();

            for (int child : graph.get(parent)) {
                ancestors.get(child).add(parent);
                ancestors.get(child).addAll(ancestors.get(parent));

                indegree[child]--;
                if (indegree[child] == 0)
                    queue.add(child);
            }
        }
        return ancestors;
    }
}