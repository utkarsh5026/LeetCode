package dynamic_programming.medium;

// https://leetcode.com/problems/target-sum/description/
// 494. Target Sum
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        // Adjusting target if it's out of possible sum range
        if (Math.abs(target) > sum) return 0;
        Integer[][] dp = new Integer[nums.length][2 * sum + 1]; // To handle negative sums
        return solve(0, 0, nums, dp, sum, target);
    }

    int solve(int idx, int currSum, int[] nums, Integer[][] dp, int sum, int target) {
        if (idx == nums.length) {
            return currSum == target ? 1 : 0;
        }

        if (dp[idx][currSum + sum] != null) return dp[idx][currSum + sum];

        int add = solve(idx + 1, currSum + nums[idx], nums, dp, sum, target);
        int subtract = solve(idx + 1, currSum - nums[idx], nums, dp, sum, target);

        dp[idx][currSum + sum] = add + subtract;
        return add + subtract;
    }
}