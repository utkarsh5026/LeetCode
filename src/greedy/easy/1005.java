package greedy.easy;

import java.util.*;

// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/description/
// 1005. Maximize Sum Of Array After K Negations
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
        }

        int sum = 0;
        while (k > 0) {
            int curr = -pq.poll();
            pq.add(curr);
            k--;
        }

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}