package sliding_window.medium;

// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/
// 2962. Count Subarrays Where Max Element Appears at Least K Times
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = max(nums);
        int left = 0;
        int cnt = 0;
        long subarrays = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == maxNum)
                cnt++;

            while (left < nums.length && cnt == k) {
                subarrays += (long) nums.length - i;
                int num = nums[left++];
                if (num == maxNum) {
                    cnt--;
                }
            }
        }

        return subarrays;
    }

    int max(int[] nums) {
        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m, nums[i]);
        }
        return m;
    }
}