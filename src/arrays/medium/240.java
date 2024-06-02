package arrays.medium;

// https://leetcode.com/problems/search-a-2d-matrix-ii/description/
// 240. Search a 2D Matrix II
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;

        // Perform binary search on each row
        for (int i = 0; i < rows; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }

        return false; // Target not found
    }

    private boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
