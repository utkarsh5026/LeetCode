package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/maximum-star-sum-of-a-graph/description/
// 2497. Maximum Star Sum of a Graph
class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<PriorityQueue<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new PriorityQueue<>((a, b) -> vals[b] - vals[a]));
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (vals[b] > 0)
                graph.get(a).offer(b);
            if (vals[a] > 0)
                graph.get(b).offer(a);
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = vals[i];
            int count = 0;
            while (!graph.get(i).isEmpty() && count < k) {
                sum += vals[graph.get(i).poll()];
                count++;
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}