package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/sum-in-a-matrix/description/
// 2679. Sum in a Matrix
class Solution {

    public int matrixSum(int[][] nums) {
        int score = 0;
        int m = nums.length;
        int n = nums[0].length;

        // Use an ArrayList of priority queues instead of an array
        List<PriorityQueue<Integer>> pqs = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max heap
            for (int num : nums[i]) {
                pq.offer(num);
            }
            pqs.add(pq);
        }

        // Perform n rounds
        for (int round = 0; round < n; round++) {
            int maxInRound = 0;
            // Find max among the top elements of all priority queues
            for (PriorityQueue<Integer> pq : pqs) {
                if (!pq.isEmpty()) {
                    maxInRound = Math.max(maxInRound, pq.poll());
                }
            }
            score += maxInRound;
        }

        return score;
    }
}