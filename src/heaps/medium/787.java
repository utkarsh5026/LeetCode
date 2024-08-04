package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// 787. Cheapest Flights Within K Stops
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int start = flight[0];
            adj.get(start).add(new int[] { flight[1], flight[2] });
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int from = curr[0];

                for (int[] neighbour : adj.get(from)) {
                    int price = neighbour[1];
                    int neighbourNode = neighbour[0];
                    if (price + curr[1] >= minCost[neighbourNode])
                        continue;

                    minCost[neighbourNode] = price + curr[1];
                    q.offer(new int[] { neighbourNode, minCost[neighbourNode] });
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}