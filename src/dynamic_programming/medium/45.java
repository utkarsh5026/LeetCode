package dynamic_programming.medium;

import java.util.*;

/// https://leetcode.com/problems/jump-game-ii/description/
// 45. Jump Game II
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    int solve(int idx, int[] nums, int[] dp) {
        if (idx >= nums.length - 1) {
            return 0;
        }

        if (dp[idx] != -1)
            return dp[idx];

        int minPath = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx]; i++) {
            if (idx + i < nums.length) { // Ensure we do not go out of bounds
                int dist = solve(idx + i, nums, dp);
                if (dist != Integer.MAX_VALUE) { // Check if it's a valid path
                    minPath = Math.min(minPath, 1 + dist);
                }
            }
        }

        dp[idx] = minPath;
        return dp[idx];
    }
}