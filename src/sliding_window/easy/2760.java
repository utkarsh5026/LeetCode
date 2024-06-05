package sliding_window.easy;

// https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/description/
// 2760. Longest Even Odd Subarray With Threshold
class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean sign = nums[i] % 2 == 0;
            if (!sign || nums[i] > threshold)
                continue;
            maxLength = Math.max(1, maxLength);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > threshold || (nums[j] % 2 == 0) == sign)
                    break;

                maxLength = Math.max(maxLength, j - i + 1);
                sign = !sign;
            }
        }

        return maxLength;
    }
}