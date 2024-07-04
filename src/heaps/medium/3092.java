package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/most-frequent-ids/description/
// 3092. Most Frequent IDs
class Solution {
    class Pair {
        int id;
        long frequency;

        Pair(int id, long frequency) {
            this.id = id;
            this.frequency = frequency;
        }
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, Long> idFreq = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(b.frequency, a.frequency));

        for (int i = 0; i < n; i++) {
            int id = nums[i];
            long change = freq[i];

            // Update the frequency of the current ID
            long oldFreq = idFreq.getOrDefault(id, 0L);
            long newFreq = oldFreq + change;
            idFreq.put(id, newFreq);

            // Update the priority queue
            pq.offer(new Pair(id, newFreq));

            // Get the most frequent ID count
            while (!pq.isEmpty() && pq.peek().frequency != idFreq.get(pq.peek().id)) {
                pq.poll();
            }

            ans[i] = pq.isEmpty() ? 0 : pq.peek().frequency;
        }

        return ans;
    }
}