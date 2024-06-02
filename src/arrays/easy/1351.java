package arrays.easy;

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
// 1351. Count Negative Numbers in a Sorted Matrix
class Solution {
    public int countNegatives(int[][] grid) {
        int negatives = 0;

        for (int[] row : grid) {
            negatives += findNegatives(row);
        }

        return negatives;
    }

    public int findNegatives(int[] arr) {
        int count = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (arr[left] >= 0 && arr[right] >= 0) {
                return count;
            }

            int mid = left + (right - left) / 2;
            int element = arr[mid];

            if (element >= 0) {
                left = mid + 1;
            } else {
                count += right - mid + 1;
                right = mid - 1;
            }
        }
        return count;
    }
}
