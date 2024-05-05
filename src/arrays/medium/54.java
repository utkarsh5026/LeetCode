package arrays.medium;

import java.util.*;

// https://leetcode.com/problems/spiral-matrix/description/
// 54. Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                spiral.add(matrix[top][i]);
            }

            for (int i = top + 1; i < bottom; i++) {
                spiral.add(matrix[i][right]);
            }

            if (top != bottom) {
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
            }

            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    spiral.add(matrix[i][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return spiral;
    }
}