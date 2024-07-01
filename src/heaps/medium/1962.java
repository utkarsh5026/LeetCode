package heaps.medium;

import java.util.*;

// https:// leetcode.com/problems/remove-stones-to-minimize-the-total/description/
// 1962. Remove Stones to Minimize the Total
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            maxHeap.add(pile);
        }

        for (int i = 0; i < k; i++) {
            int largest = maxHeap.poll();
            int toRemove = largest / 2;
            maxHeap.add(largest - toRemove);
        }

        int left = 0;
        while (!maxHeap.isEmpty()) {
            left += maxHeap.poll();
        }
        return left;
    }
}