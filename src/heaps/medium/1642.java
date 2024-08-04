package heaps.medium;

import java.util.PriorityQueue;

// https://leetcode.com/problems/furthest-building-you-can-reach/description/
// 1642. Furthest Building You Can Reach
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0)
                minHeap.add(diff);

            if (minHeap.size() > ladders)
                bricks -= minHeap.poll();

            if (bricks < 0)
                return i;
        }

        return heights.length - 1;
    }
}