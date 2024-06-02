package greedy.easy;

import java.util.*;

// https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/description/
// 1403. Minimum Subsequence in Non-Increasing Order

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int total = totalSum(nums);
        int half = total / 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> subsequence = new ArrayList<>();

        for (int num : nums) {
            pq.add(num);
        }

        while (half >= 0 && !pq.isEmpty()) {
            int maximum = pq.poll();
            half -= maximum;
            subsequence.add(maximum);
        }

        return subsequence;
    }

    int totalSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
