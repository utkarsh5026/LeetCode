package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
// 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
class Solution {

    class Node {
        int city;
        int distance;

        Node(int city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Node>> cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cities.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            cities.get(from).add(new Node(to, weight));
            cities.get(to).add(new Node(from, weight));
        }

        List<Integer> reachable = new ArrayList<>();
        for (int city = 0; city < cities.size(); city++) {
            int[] dist = djikstra(cities, city);
            int cnt = 0;
            for (int distance : dist) {
                if (distance <= distanceThreshold)
                    cnt++;
            }
            reachable.add(cnt);
        }

        return findMinCity(reachable);
    }

    int[] djikstra(List<List<Node>> cities, int source) {
        int[] dist = new int[cities.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<int[]> queue = new ArrayDeque<>();
        dist[source] = 0;
        queue.add(new int[] { source, dist[source] });

        while (!queue.isEmpty()) {
            int[] nodeDist = queue.pollFirst();
            int node = nodeDist[0];
            int distance = nodeDist[1];

            if (distance > dist[node])
                continue;

            for (Node city : cities.get(node)) {
                int toDist = distance + city.distance;
                if (dist[city.city] > toDist) {
                    dist[city.city] = toDist;
                    queue.add(new int[] { city.city, toDist });
                }
            }
        }

        return dist;
    }

    int findMinCity(List<Integer> reachable) {
        int idx = 0;
        int min = reachable.get(0);

        for (int i = 1; i < reachable.size(); i++) {
            int cnt = reachable.get(i);
            if (cnt <= min) {
                min = cnt;
                idx = i;
            }
        }

        return idx;
    }
}