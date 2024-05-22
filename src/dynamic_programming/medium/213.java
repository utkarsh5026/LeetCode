package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/house-robber-ii/description/
// 213. House Robber II
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        // Memoization arrays
        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        // Case 1: Exclude the last house
        int rob1 = robRecursive(nums, 0, n - 2, memo1);

        // Case 2: Exclude the first house
        int rob2 = robRecursive(nums, 1, n - 1, memo2);

        return Math.max(rob1, rob2);
    }

    private int robRecursive(int[] nums, int start, int end, int[] memo) {
        if (start > end) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }

        int robCurrent = nums[start] + robRecursive(nums, start + 2, end, memo);
        int skipCurrent = robRecursive(nums, start + 1, end, memo);

        memo[start] = Math.max(robCurrent, skipCurrent);
        return memo[start];
    }
}
