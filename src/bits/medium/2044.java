package bits.medium;

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/
// 2044. Count Number of Maximum Bitwise-OR Subsets
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums)
            maxOr |= num;

        return backtrack(0, nums, 0, maxOr);
    }

    int backtrack(int idx, int[] nums, int orSoFar, int maxOr) {
        if (idx >= nums.length)
            return orSoFar == maxOr ? 1 : 0; // Return 1 if we've reached maxOr, 0 otherwise

        int cnt = 0;
        cnt += backtrack(idx + 1, nums, orSoFar | nums[idx], maxOr);
        cnt += backtrack(idx + 1, nums, orSoFar, maxOr);

        return cnt;
    }
}