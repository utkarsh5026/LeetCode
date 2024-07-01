package heaps.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
// 2558. Take Gifts From the Richest Pile
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < gifts.length; i++) {
            pq.add(gifts[i]);
        }

        for (int i = 0; i < k; i++) {
            int maxGift = pq.poll();
            int floorRoot = (int) Math.floor(Math.sqrt(maxGift));
            pq.add(floorRoot);
        }

        long giftsRemain = 0;
        while (!pq.isEmpty()) {
            giftsRemain += pq.poll();
        }
        return giftsRemain;
    }
}