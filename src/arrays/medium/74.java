package arrays.medium;

// https://leetcode.com/problems/search-a-2d-matrix/description/
// 74. Search a 2D Matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midRowStart = matrix[mid][0];
            int midRowEnd = matrix[mid][matrix[mid].length - 1];

            if (target < midRowStart)
                right = mid - 1;
            else if (target > midRowEnd)
                left = mid + 1;
            else
                return bs(matrix[mid], target);
        }

        return false;
    }

    boolean bs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return true;
            else if (target > arr[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}