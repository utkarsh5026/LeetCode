package bits.medium;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/
// 2997. Minimum Number of Operations to Make Array XOR Equal to K
class Solution {
    public int minOperations(int[] nums, int k) {
        int initialXOR = 0;
        for (int num : nums) {
            initialXOR ^= num;
        }
        int targetXOR = initialXOR ^ k;
        return Integer.bitCount(targetXOR);
    }
}