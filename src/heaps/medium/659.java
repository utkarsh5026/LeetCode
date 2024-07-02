package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
// 659. Split Array into Consecutive Subsequences
class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int num : nums) {
            // Remove and check sequences that can't be extended
            while (!pq.isEmpty() && pq.peek()[0] + 1 < num) {
                if (pq.poll()[1] < 3)
                    return false;
            }

            if (pq.isEmpty() || pq.peek()[0] == num) {
                // Start a new sequence
                pq.offer(new int[] { num, 1 });
            } else {
                // Extend existing sequence
                int[] seq = pq.poll();
                pq.offer(new int[] { num, seq[1] + 1 });
            }
        }

        // Check remaining sequences
        while (!pq.isEmpty()) {
            if (pq.poll()[1] < 3)
                return false;
        }

        return true;
    }
}