package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
// 1942. The Number of the Smallest Unoccupied Chair
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[][] sortedTimes = new int[times.length][3];
        for (int i = 0; i < times.length; i++) {
            sortedTimes[i] = new int[] { times[i][0], times[i][1], i };
        }
        Arrays.sort(sortedTimes, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        PriorityQueue<int[]> departures = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int maxChair = 0;

        for (int[] event : sortedTimes) {
            int arrivalTime = event[0];
            int departureTime = event[1];
            int friendIndex = event[2];

            while (!departures.isEmpty() && departures.peek()[0] <= arrivalTime) {
                availableChairs.offer(departures.poll()[1]);
            }

            int assignedChair;
            if (availableChairs.isEmpty()) {
                assignedChair = maxChair++;
            } else {
                assignedChair = availableChairs.poll();
            }

            if (friendIndex == targetFriend) {
                return assignedChair;
            }

            departures.offer(new int[] { departureTime, assignedChair });
        }

        return -1;
    }
}