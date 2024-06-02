package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/count-days-without-meetings/description/
// 3169. Count Days Without Meetings
class Solution {

    public int countDays(int days, int[][] meetings) {
        List<int[]> overlapped = overlap(meetings);
        int n = overlapped.size();
        int nowork = 0;
        for (int i = 0; i < n - 1; i++) {
            nowork += overlapped.get(i + 1)[0] - overlapped.get(i)[1] - 1;
        }

        nowork += overlapped.get(0)[0] - 1;
        nowork += days - overlapped.get(n - 1)[1];
        return nowork;
    }

    public static List<int[]> overlap(int[][] meetings) {
        if (meetings.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> overlapped = new ArrayList<>();
        int[] start = meetings[0];

        for (int i = 1; i < meetings.length; i++) {
            int begin = meetings[i][0];
            int end = meetings[i][1];
            if (begin <= start[1]) {
                start[1] = Math.max(start[1], end);
            } else {
                overlapped.add(start);
                start = meetings[i];
            }
        }

        overlapped.add(start);
        return overlapped;
    }

}
