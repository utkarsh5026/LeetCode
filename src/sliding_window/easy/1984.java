package sliding_window.easy;

import java.util.*;

// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
// 1984. Minimum Difference Between Highest and Lowest of K Scores
class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length <= 1)
            return 0;
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int lowest = nums[i];
            int highest = nums[i + k - 1];

            minDiff = Math.min(minDiff, highest - lowest);
        }

        return minDiff;
    }
}