package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/car-pooling/description/
// 1094. Car Pooling
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int currentPassengers = 0;

        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                currentPassengers -= pq.poll()[1];
            }

            currentPassengers += passengers;

            if (currentPassengers > capacity) {
                return false;
            }

            pq.offer(new int[] { end, passengers });
        }

        return true;
    }
}