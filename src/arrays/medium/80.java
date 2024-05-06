package arrays.medium;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
// 80. Remove Duplicates from Sorted Array II
class Solution {
    public int removeDuplicates(int[] nums) {
        int dups = 0;
        int idx = 0;

        while (idx < nums.length) {
            int curr = nums[idx];
            int currCount = 1;

            while (idx < nums.length - 1) {
                int next = nums[idx + 1];
                if (next != curr)
                    break;
                idx++;
                currCount++;
            }
            nums[dups++] = curr;
            if (currCount >= 2)
                nums[dups++] = curr;
            idx++;
        }

        return dups;
    }
}
