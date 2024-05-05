package arrays.easy;

// https://leetcode.com/problems/move-zeroes/description/
// 283. Move Zeroes
class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = moveAllNonZeroesToTheBegining(nums);
        fillRemainingPositionsWithZero(nums, lastNonZeroFoundAt);
    }

    private int moveAllNonZeroesToTheBegining(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        return lastNonZeroFoundAt;
    }

    private void fillRemainingPositionsWithZero(int[] nums, int lastNonZeroFoundAt) {
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
