package sliding_window.medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-erasure-value/description/
// 1695. Maximum Erasure Value
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return findMaxScore(prefixSum, nums);
    }

    int findMaxScore(int[] prefixSum, int[] nums) {
        int maxScore = Integer.MIN_VALUE;
        Set<Integer> unique = new HashSet<>();
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            while (unique.contains(nums[i])) {
                unique.remove(nums[left]);
                left++;
            }

            unique.add(nums[i]);
            int currentScore = prefixSum[i] - (left > 0 ? prefixSum[left - 1] : 0);
            maxScore = Math.max(currentScore, maxScore);
        }
        return maxScore;
    }
}
