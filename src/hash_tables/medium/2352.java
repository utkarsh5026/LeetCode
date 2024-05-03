package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/equal-row-and-column-pairs/description/
// 2352. Equal Row and Column Pairs
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowElementsMap = new HashMap<>();
        updateRowElementsMap(grid, rowElementsMap);
        return findMatchingColumns(grid, rowElementsMap);
    }

    private void updateRowElementsMap(int[][] grid, Map<String, Integer> rowElementsMap) {
        int size = grid.length;
        for (int i = 0; i < size; i++) {
            int[] row = grid[i];
            String rowElement = arrToString(row);
            rowElementsMap.computeIfAbsent(rowElement, el -> 0);
            rowElementsMap.put(rowElement, rowElementsMap.get(rowElement) + 1);
        }
    }

    private String arrToString(int[] row) {
        StringBuilder sb = new StringBuilder();
        for (int num : row) {
            sb.append(num).append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private int findMatchingColumns(int[][] grid, Map<String, Integer> rowMap) {
        int cols = grid.length;
        int rows = grid.length;

        int matching = 0;
        for (int i = 0; i < cols; i++) {
            int[] col = new int[rows];

            for (int j = 0; j < rows; j++) {
                col[j] = grid[j][i];
            }
            String colRepr = arrToString(col);

            if (!rowMap.containsKey(colRepr))
                continue;

            matching += rowMap.get(colRepr);
        }
        return matching;
    }
}