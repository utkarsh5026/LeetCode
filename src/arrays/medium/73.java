package arrays.medium;

import java.util.*;

// https://leetcode.com/problems/set-matrix-zeroes/description/
// 73. Set Matrix Zeroes
class Solution {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> zeroIndices = getZeroesIndices(matrix);

        for (int i = 0; i < matrix.length; i++) {
            List<Integer> zeroesInRow = zeroIndices.get(i);
            if (zeroesInRow.isEmpty())
                continue;

            for (int col : zeroesInRow) {
                setEntireColumnZero(col, matrix);
            }

            Arrays.fill(matrix[i], 0);
        }
    }

    private List<List<Integer>> getZeroesIndices(int[][] matrix) {
        List<List<Integer>> zeroIndices = new ArrayList<>();
        for (int[] row : matrix) {
            List<Integer> indices = new ArrayList<>();

            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0)
                    indices.add(i);
            }
            zeroIndices.add(indices);
        }

        return zeroIndices;
    }

    private void setEntireColumnZero(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}