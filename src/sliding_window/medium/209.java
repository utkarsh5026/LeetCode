package sliding_window.medium;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/
// 209. Minimum Size Subarray Sum
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int left = 0;

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum >= target) {
                while (left < i && currSum - nums[left] >= target) {
                    currSum -= nums[left++];
                }
                minLength = Math.min(i - left + 1, minLength);
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}