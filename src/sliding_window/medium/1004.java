package sliding_window.medium;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/
// 1004. Max Consecutive Ones III
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxOnesLength = 0;
        int zeroCount = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxOnesLength = Math.max(maxOnesLength, right - left + 1);
        }

        return maxOnesLength;
    }
}
