package greedy.medium;

// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/
// 1605. Find Valid Matrix Given Row and Column Sums
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currRowSum = rowSum[i];
                int currColSum = colSum[j];

                int val = Math.min(currColSum, currRowSum);
                colSum[j] -= val;
                rowSum[i] -= val;

                result[i][j] = val;
            }
        }

        return result;
    }
}