package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/
// 1985. Find the Kth Largest Integer in the Array
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        for (String num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}