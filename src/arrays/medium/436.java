package arrays.medium;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/find-right-interval/description
// 436. Find Right Interval
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        int[][] indexedIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedIntervals[i][0] = intervals[i][0];
            indexedIntervals[i][1] = i;
        }

        Arrays.sort(indexedIntervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int idx = binarySearch(indexedIntervals, target);
            result[i] = idx;
        }

        return result;
    }

    private int binarySearch(int[][] intervals, int target) {
        int left = 0, right = intervals.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left < intervals.length ? intervals[left][1] : -1;
    }
}
