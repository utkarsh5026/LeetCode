package arrays.easy;

// https://leetcode.com/problems/convert-1d-array-into-2d-array/description/
// 2022. Convert 1D Array Into 2D Arrays
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if the number of elements matches m * n
        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result;
    }
}