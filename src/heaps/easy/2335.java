package heaps.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/description/
// 2335. Minimum Amount of Time to Fill Cups
class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int am : amount) {
            if (am > 0)
                maxHeap.add(am);
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            time++;
            int max = maxHeap.poll();
            if (!maxHeap.isEmpty()) {
                int secMax = maxHeap.poll();
                if (secMax > 1)
                    maxHeap.add(secMax - 1);
            }
            if (max > 1)
                maxHeap.add(max - 1);
        }

        return time;
    }
}
