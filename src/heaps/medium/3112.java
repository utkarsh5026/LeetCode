package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes/description/
// 3112. Minimum Time to Visit Disappearing Nodes
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // Build the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], length = edge[2];
            graph.get(u).add(new int[] { v, length });
            graph.get(v).add(new int[] { u, length });
        }

        // Create disappearance time map
        int[] disappearTime = new int[n];
        Arrays.fill(disappearTime, Integer.MAX_VALUE);
        for (int i = 0; i < disappear.length; i++) {
            disappearTime[i] = disappear[i];
        }

        // Dijkstra's algorithm
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { 0, 0 }); // node, time

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            if (time > minTime[node])
                continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeLength = neighbor[1];
                int newTime = time + edgeLength;

                if (newTime < minTime[nextNode] && newTime < disappearTime[nextNode]) {
                    minTime[nextNode] = newTime;
                    pq.offer(new int[] { nextNode, newTime });
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) {
                minTime[i] = -1;
            }
        }

        return minTime;
    }
}