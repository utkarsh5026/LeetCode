package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// 373. Find K Pairs with Smallest Sums
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[a[1]] + nums2[a[2]]));
        List<List<Integer>> kSmallest = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            pq.add(new int[] { i, 0 });
        }

        while (k > 0) {
            int[] pairIndex = pq.poll();
            int nums1Idx = pairIndex[0];
            int num2Idx = pairIndex[1];
            kSmallest.add(Arrays.asList(nums1Idx, num2Idx));

            if (num2Idx < nums2.length - 1)
                pq.add(new int[] { nums1Idx, num2Idx });
            k--;
        }
        return kSmallest;
    }
}