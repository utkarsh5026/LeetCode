package arrays.medium;

import java.util.*;

// https://leetcode.com/problems/merge-intervals/description/
// 56. Merge Intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> overlapped = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] overlap = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int currStart = curr[0];
            int currEnd = curr[1];

            if (currStart < overlap[1]) {
                overlap[1] = Math.max(overlap[1], currEnd);
            } else {
                overlapped.add(overlap);
                overlap = curr;
            }
        }

        overlapped.add(overlap);
        return overlapped.toArray(new int[overlapped.size()][]);
    }
}