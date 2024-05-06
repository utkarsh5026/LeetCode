package arrays.medium;

// https://leetcode.com/problems/container-with-most-water/description/
// 11. Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int leftSide = height[left];
            int rightSide = height[right];

            int length = Math.min(leftSide, rightSide);
            int width = right - left;

            int area = length * width;
            max = Math.max(max, area);

            if (leftSide < rightSide)
                left++;
            else
                right--;
        }

        return max;
    }
}
