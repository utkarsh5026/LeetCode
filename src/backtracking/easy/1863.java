package backtracking.easy;

// https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
// 1863. Sum of All Subset XOR Totals
class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(0, nums, 0);
    }

    int solve(int idx, int[] nums, int xor) {
        if (idx == nums.length)
            return xor;

        int take = solve(idx + 1, nums, xor ^ nums[idx]);
        int skip = solve(idx + 1, nums, xor);

        return take + skip;

    }
}