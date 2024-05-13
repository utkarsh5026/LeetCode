package sliding_window.medium;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
// 1493. Longest Subarray of 1's After Deleting One Element
class Solution {
    public int longestSubarray(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        int currLength = 0;
        boolean zeroFound = false;
        int lastZeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if (curr == 1) {
                currLength++;
                continue;
            }

            if (curr == 0 && !zeroFound) {
                lastZeroIdx = i;
                zeroFound = true;
                currLength++;
                continue;
            }
            maxLength = Math.max(maxLength, currLength);
            currLength = i - lastZeroIdx;
            lastZeroIdx = i;
        }

        return Math.max(currLength, maxLength) - 1;
    }
}