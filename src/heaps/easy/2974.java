package heaps.easy;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-number-game/description/
// 2974. Minimum Number Game
class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            int min = pq.poll();
            int secondMin = pq.poll();

            nums[idx++] = secondMin;
            nums[idx++] = min;
        }

        return nums;
    }
}