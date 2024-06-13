package arrays.medium;

// https://leetcode.com/problems/sort-colors/description/
// 75. Sort Colors
class Solution {

    public void sortColors(int[] nums) {
        int zeroEndsAt = swapColor(0, 0, nums);
        swapColor(zeroEndsAt, 1, nums);
    }

    int swapColor(int start, int color, int[] colors) {
        int end = colors.length - 1;
        while (start <= end) {
            while (start < colors.length && colors[start] == color) {
                start++;
            }
            while (end >= 0 && colors[end] != color) {
                end--;
            }
            if (start < end) {
                int temp = colors[start];
                colors[start] = colors[end];
                colors[end] = temp;
                start++;
                end--;
            }
        }

        while (start < colors.length && colors[start] == color) {
            start++;
        }
        return start;
    }
}