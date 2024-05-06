package arrays.medium;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// 26. Remove Duplicates from Sorted Array
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int currUnique = nums[0];
        int totalUnique = 1;

        for (int num : nums) {
            if (num != currUnique) {
                currUnique = num;
                nums[totalUnique] = currUnique;
                totalUnique++;
            }
        }

        return totalUnique;
    }
}
