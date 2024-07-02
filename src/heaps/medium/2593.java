package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/
// 2593. Find Score of an Array After Marking All Elements
class Solution {

    class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0;

        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> {
            if (a.value != b.value)
                return Integer.compare(a.value, b.value);

            return Integer.compare(a.index, b.index);
        });

        // Add all elements to the priority queue
        for (

                int i = 0; i < n; i++) {
            pq.offer(new Element(nums[i], i));
        }

        while (!pq.isEmpty()) {
            Element current = pq.poll();

            if (!marked[current.index]) {
                score += current.value;

                for (int j = Math.max(0, current.index - 1); j <= Math.min(n - 1, current.index + 1); j++) {
                    marked[j] = true;
                }
            }
        }

        return score;
    }
}