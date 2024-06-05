package sliding_window.easy;

// https:// leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/description/
// 3095. Shortest Subarray With OR at Least K I
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i; j < nums.length; j++) {
                num = num | nums[j];
                if (num >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}