package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-operations-to-halve-array-sum/description/
// 2208. Minimum Operations to Halve Array Sum
class Solution {
    public int halveArray(int[] nums) {
        // Calculate the initial sum
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            sum += num;
            pq.offer((double) num);
        }

        double target = sum / 2;
        double reduced = 0;
        int operations = 0;

        while (reduced < target) {
            double current = pq.poll();
            double half = current / 2;
            reduced += half;
            pq.offer(half);
            operations++;
        }

        return operations;
    }
}