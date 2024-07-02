package heaps.medium;

import java.util.*;

// https:// leetcode.com/problems/network-delay-time/description/
// 743. Network Delay Time
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create graph as an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[] { time[1], time[2] });
        }

        // Map to store the minimum time to each node
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(k, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, k });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentNode = current[1];

            if (currentDist > dist.get(currentNode))
                continue;

            // Process each adjacent node
            if (graph.containsKey(currentNode)) {
                for (int[] edge : graph.get(currentNode)) {
                    int nextNode = edge[0];
                    int timeToNextNode = edge[1];
                    int newDist = currentDist + timeToNextNode;
                    if (newDist < dist.get(nextNode)) {
                        dist.put(nextNode, newDist);
                        pq.offer(new int[] { newDist, nextNode });
                    }
                }
            }
        }

        // Calculate the maximum time from the dist map
        int maxTime = Collections.max(dist.values());
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
