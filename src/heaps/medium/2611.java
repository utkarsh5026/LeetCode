package heaps.medium;

import java.util.PriorityQueue;

// https://leetcode.com/problems/mice-and-cheese/description/
// 2611. Mice and Cheese
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int totalReward = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> (reward1[b] - reward2[b]) - (reward1[a] - reward2[a]));

        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }

        for (int i = 0; i < k; i++) {
            int index = pq.poll();
            totalReward += reward1[index];
        }

        while (!pq.isEmpty()) {
            int index = pq.poll();
            totalReward += reward2[index];
        }

        return totalReward;
    }
}