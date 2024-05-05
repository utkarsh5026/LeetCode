package arrays.easy;

// https://leetcode.com/problems/find-pivot-index/description/
// 724. Find Pivot Index

class Solution {
    public int pivotIndex(int[] nums) {
        int items = nums.length;
        int[] leftSum = new int[items];
        int[] rightSum = new int[items];

        leftSum[0] = nums[0];
        rightSum[items - 1] = nums[items - 1];

        fillLeftAndRight(leftSum, rightSum, nums);
        return findPivotIndex(leftSum, rightSum);
    }

    private void fillLeftAndRight(int[] left, int[] right, int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i];
            int rightIndex = nums.length - i - 1;
            right[rightIndex] = nums[rightIndex] + right[rightIndex + 1];
        }
    }

    private int findPivotIndex(int[] left, int[] right) {
        for (int i = 0; i < left.length; i++) {
            int sumFromLeft = i > 0 ? left[i - 1] : 0;
            int sumFromRight = i < right.length - 1 ? right[i + 1] : 0;

            if (sumFromLeft == sumFromRight)
                return i;
        }

        return -1;
    }
}