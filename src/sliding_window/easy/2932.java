package sliding_window.easy;

// https://leetcode.com/problems/maximum-strong-pair-xor-i/description/
// 2932. Maximum Strong Pair XOR I
class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int maxXor = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                boolean isStrongPair = Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j]);
                if (!isStrongPair)
                    continue;
                maxXor = Math.max(maxXor, nums[i] ^ nums[j]);
            }
        }
        return maxXor;
    }
}
