package graphs.hard;

import java.util.*;

// https://leetcode.com/problems/parallel-courses-iii/description/
// 2050. Parallel Courses III
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n + 1];
        int[] totalTime = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            indegree[relation[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                totalTime[i] = time[i - 1];
            }
        }

        int minTimeToCompleteAllCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            minTimeToCompleteAllCourses = Math.max(minTimeToCompleteAllCourses, totalTime[current]);

            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;

                totalTime[neighbor] = Math.max(totalTime[neighbor], totalTime[current] + time[neighbor - 1]);

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return minTimeToCompleteAllCourses;
    }
}
