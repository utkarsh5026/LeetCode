package heaps.easy;

import java.util.*;

// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/
// 2099. Find Subsequence of Length K With the Largest Sum
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[] { nums[i], i });
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<int[]> resultPairs = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            resultPairs.add(minHeap.poll());
        }

        Collections.sort(resultPairs, Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        int idx = 0;
        for (int[] pair : resultPairs) {
            result[idx++] = pair[0];
        }

        return result;
    }
}