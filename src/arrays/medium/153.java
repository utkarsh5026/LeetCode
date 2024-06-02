package arrays.medium;

//  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// 153. Find Minimum in Rotated Sorted Array
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int element = nums[mid];

            if (element > nums[right])
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }
}
