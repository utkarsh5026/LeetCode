package arrays.easy;

// https://leetcode.com/problems/binary-search/description/
// 704. Binary Search
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int element = nums[mid];

            if (element == target)
                return mid;
            else if (target > element)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
