import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/// https://leetcode.com/problems/lucky-numbers-in-a-matrix/description
// 1380. Lucky Numbers in a Matrix
class Solution {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> minInRows = new HashSet<>();
        for (int[] ints : matrix) {
            int min = ints[0];
            for (int j = 1; j < n; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                }
            }
            minInRows.add(min);
        }
        Set<Integer> maxInCols = new HashSet<>();
        for (int j = 0; j < n; j++) {
            int max = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxInCols.add(max);
        }


        List<Integer> luckyNumbers = new ArrayList<>();
        for (Integer num : minInRows) {
            if (maxInCols.contains(num)) {
                luckyNumbers.add(num);
            }
        }

        return luckyNumbers;
    }
}
