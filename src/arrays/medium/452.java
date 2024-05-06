package arrays.medium;

import java.util.Arrays;

/// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
// 452. Minimum Number of Arrows to Burst Balloons
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int shotsFired = 0;

        int[] ballonRange = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] ballonRadius = points[i];
            if (ballonRadius[0] <= ballonRange[1]) {
                ballonRange[1] = Math.min(ballonRadius[1], ballonRange[1]);
                continue;
            }
            shotsFired++;
            ballonRange = ballonRadius;
        }

        return shotsFired + 1;
    }
}