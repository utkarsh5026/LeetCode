package arrays.medium;

import java.util.*;

// https://leetcode.com/problems/magnetic-force-between-two-balls/description/
// 1552. Magnetic Force Between Two Balls
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canPlace(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canPlace(int[] position, int m, int distance) {
        int count = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= distance) {
                count++;
                last = position[i];
                if (count >= m) {
                    return true;
                }
            }
        }

        return false;
    }
}