package greedy.medium;

import java.util.Arrays;

// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
// 1877. Minimize Maximum Pair Sum in Array
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxPairSum = 0;

        for (int i = 0; i < n / 2; i++) {
            maxPairSum = Math.max(maxPairSum, nums[i] + nums[n - 1 - i]);
        }

        return maxPairSum;
    }
}
