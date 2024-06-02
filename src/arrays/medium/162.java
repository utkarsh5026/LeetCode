package arrays.medium;

// https://leetcode.com/problems/find-peak-element/description/
// 162. Find Peak Element
class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int curr = nums[mid];
            int next = nums[mid + 1];

            if (curr > next)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}