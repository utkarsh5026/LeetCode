package heaps.easy;

import java.util.*;

// https://leetcode.com/problems/last-stone-weight/description/
// 1046. Last Stone Weight
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while (!pq.isEmpty()) {
            if (pq.size() == 1)
                return pq.poll();

            int largest = pq.poll();
            int secLargest = pq.poll();

            int destroyed = largest - secLargest;
            if (destroyed > 0)
                pq.add(destroyed);
        }

        return 0;
    }
}