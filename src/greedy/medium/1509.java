package greedy.medium;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/description/
// 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
class Solution {
    public int minDifference(int[] nums) {
        int size = nums.length;
        if (size <= 3)
            return 0;

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= 3; i++) {
            int fromEnd = nums[size - 1 - i];
            int fromStart = nums[3 - i];

            minDiff = Math.min(minDiff, fromEnd - fromStart);
        }

        return minDiff;
    }
}