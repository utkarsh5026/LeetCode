package arrays.medium;

// https://leetcode.com/problems/product-of-array-except-self/description/
// 238. Product of Array Except Self
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prodFromLeft = new int[length];
        int[] prodFromRight = new int[length];

        prodFromLeft[0] = nums[0];
        prodFromRight[length - 1] = nums[length - 1];
        fillLeftAndRightProdArrays(prodFromLeft, prodFromRight, nums);

        return getProductsWithoutSelf(prodFromLeft, prodFromRight);
    }

    private void fillLeftAndRightProdArrays(int[] prodFromLeft, int[] prodFromRight, int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            prodFromLeft[i] = nums[i] * prodFromLeft[i - 1];
            int rightIndex = nums.length - i - 1;

            prodFromRight[rightIndex] = nums[rightIndex] * prodFromRight[rightIndex + 1];
        }
    }

    private int[] getProductsWithoutSelf(int[] prodFromLeft, int[] prodFromRight) {
        int items = prodFromLeft.length;
        int[] exceptSelf = new int[items];

        for (int i = 0; i < items; i++) {
            int fromLeft = i > 0 ? prodFromLeft[i - 1] : 1;
            int fromRight = i < items - 1 ? prodFromRight[i + 1] : 1;

            exceptSelf[i] = fromLeft * fromRight;
        }

        return exceptSelf;
    }
}