package heaps.medium;

import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-gap/description/
// 164. Maximum Gap
class Solution {
    public int maximumGap(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
        }

        int maxGap = 0;

        while (pq.size() > 1) {
            int top = pq.poll();
            maxGap = Math.max(pq.peek() - top, maxGap);
        }

        return maxGap;
    }
}
