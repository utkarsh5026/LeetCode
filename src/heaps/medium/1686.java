package heaps.medium;

import java.util.PriorityQueue;

// https://leetcode.com/problems/stone-game-vi/description/
// 1686. Stone Game VI
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i] });
        }

        int aliceScore = 0;
        int bobScore = 0;
        boolean aliceTurn = true;

        // Pick stones alternately
        while (!pq.isEmpty()) {
            int[] stone = pq.poll();
            if (aliceTurn) {
                aliceScore += stone[1];
            } else {
                bobScore += stone[2];
            }
            aliceTurn = !aliceTurn;
        }

        if (aliceScore > bobScore) {
            return 1;
        } else if (bobScore > aliceScore) {
            return -1;
        } else {
            return 0;
        }
    }
}