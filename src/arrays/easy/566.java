package arrays.easy;

// https://leetcode.com/problems/reshape-the-matrix/description/
// 566. Reshape the Matrixs
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        if (rows * cols != r * c)
            return mat;

        int[][] reshaped = new int[r][c];
        int flatten = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int crow = flatten / cols;
                int ccol = flatten % cols;

                reshaped[i][j] = mat[crow][ccol];
                flatten++;
            }
        }

        return reshaped;
    }
}