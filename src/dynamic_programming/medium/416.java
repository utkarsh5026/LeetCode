package dynamic_programming.medium;

// https://leetcode.com/problems/partition-equal-subset-sum/description/
// 416. Partition Equal Subset Sum
class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return canPartitionHelper(nums, 0, target, dp);
    }

    private boolean canPartitionHelper(int[] nums, int index, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length || target < 0) {
            return false;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean take = canPartitionHelper(nums, index + 1, target - nums[index], dp);
        boolean skip = canPartitionHelper(nums, index + 1, target, dp);

        dp[index][target] = take || skip;
        return dp[index][target];
    }
}
