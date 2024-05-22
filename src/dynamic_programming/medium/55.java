package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/jump-game/description/
// 55. Jump Game
class Solution {
    public boolean canJump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    boolean solve(int idx, int[] nums, int[] dp) {
        if (idx >= nums.length - 1)
            return true;
        if (dp[idx] != -1)
            return dp[idx] == 1;

        int jumpSteps = nums[idx];

        for (int i = 1; i <= jumpSteps; i++) {
            boolean result = solve(idx + i, nums, dp);

            if (result) {
                dp[idx] = 1;
                return true;
            }
        }

        dp[idx] = 0;
        return false;
    }
}