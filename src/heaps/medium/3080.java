package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/mark-elements-on-array-by-performing-queries/description/
// 3080. Mark Elements on Array by Performing Queries
class Solution {
    class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        long[] answer = new long[m];
        long totalSum = 0;
        boolean[] marked = new boolean[n];

        PriorityQueue<Element> unmarked = new PriorityQueue<>((a, b) -> {
            if (a.value != b.value)
                return Integer.compare(a.value, b.value);
            return Integer.compare(a.index, b.index);
        });

        // Initialize unmarked queue and calculate total sum
        for (int i = 0; i < n; i++) {
            unmarked.offer(new Element(nums[i], i));
            totalSum += nums[i];
        }

        // Process queries
        for (int i = 0; i < m; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            // Mark the element at the given index if not already marked
            if (!marked[index]) {
                marked[index] = true;
                totalSum -= nums[index];
                // We don't need to remove from PQ here, we'll skip it when we encounter it
            }

            // Mark k smallest unmarked elements
            while (k > 0 && !unmarked.isEmpty()) {
                Element smallest = unmarked.poll();
                if (!marked[smallest.index]) {
                    marked[smallest.index] = true;
                    totalSum -= smallest.value;
                    k--;
                }
            }

            answer[i] = totalSum;
        }

        return answer;
    }
}