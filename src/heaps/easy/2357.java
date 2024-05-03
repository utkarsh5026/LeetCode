package heaps.easy;

import java.util.*;

// https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/
// 2357. Make Array Zero by Subtracting Equal Amounts
class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (num != 0) {
                minHeap.add(num);
            }
        }

        int ans = 0;
        while (!minHeap.isEmpty()) {
            int t = minHeap.poll();
            while (!minHeap.isEmpty() && t == minHeap.peek()) {
                minHeap.poll();
            }
            ans++;

            PriorityQueue<Integer> newHeap = new PriorityQueue<>();
            while (!minHeap.isEmpty()) {
                newHeap.add(minHeap.poll() - t);
            }
            minHeap = newHeap;
        }

        return ans;
    }
}