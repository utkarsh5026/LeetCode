package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/maximum-number-of-eaten-apples/description/
// 1705. Maximum Number of Eaten Apples
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length;
        int day = 0;
        int eatenApples = 0;

        while (day < n || !pq.isEmpty()) {
            // Remove rotten apples
            while (!pq.isEmpty() && pq.peek()[0] <= day) {
                pq.poll();
            }

            // Add new apples
            if (day < n && apples[day] > 0) {
                pq.offer(new int[] { day + days[day], apples[day] });
            }

            // Eat an apple if available
            if (!pq.isEmpty()) {
                int[] current = pq.poll();
                eatenApples++;
                current[1]--;
                if (current[1] > 0) {
                    pq.offer(current);
                }
            }

            day++;
        }

        return eatenApples;
    }
}
