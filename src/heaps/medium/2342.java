package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/
// 2342. Max Sum of a Pair With Equal Sum of Digitss
class Solution {

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        // Group numbers by their digit sums into a priority queue
        for (int num : nums) {
            int digitSum = sumOfDigits(num);
            map.putIfAbsent(digitSum, new PriorityQueue<>(2));

            // Add number to the priority queue
            PriorityQueue<Integer> pq = map.get(digitSum);
            pq.offer(num);

            // Ensure we only keep the two largest numbers in the priority queue
            if (pq.size() > 2) {
                pq.poll();
            }
        }

        // Find the maximum sum of two numbers with the same digit sum
        int maxSum = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() > 1) {
                int first = pq.poll();
                int second = pq.poll();
                maxSum = Math.max(maxSum, first + second);
            }
        }

        return maxSum;
    }
}