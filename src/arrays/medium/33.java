package arrays.medium;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// 33. Search in Rotated Sorted Array
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = nums[mid];

            if (midElement == target)
                return mid;

            if (midElement < nums[right]) {
                if (midElement < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[left] <= target && target < midElement)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }

        return -1;
    }
}