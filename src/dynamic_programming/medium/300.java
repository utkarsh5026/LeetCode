package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
//  300. Longest Increasing Subsequence
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findLongest(-1, 0, nums, dp);
    }

    int findLongest(int prevIdx, int idx, int[] nums, int[][] dp) {
        if (idx == nums.length) {
            return 0;
        }

        // Use dp[prevIdx + 1][idx] as prevIdx can be -1 which is out of bounds
        if (dp[prevIdx + 1][idx] != -1) {
            return dp[prevIdx + 1][idx];
        }

        int take = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            take = 1 + findLongest(idx, idx + 1, nums, dp);
        }

        int skip = findLongest(prevIdx, idx + 1, nums, dp);

        dp[prevIdx + 1][idx] = Math.max(take, skip);
        return dp[prevIdx + 1][idx];
    }

}
