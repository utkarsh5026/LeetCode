package dynamic_programming.easy;

import java.util.*;

// https://leetcode.com/problems/pascals-triangle-ii/description/
// 119. Pascal's Triangle ||
class Solution {

    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }

    public List<List<Integer>> generate(int numRows) {
        // Base case: if numRows is 0, return an empty list
        if (numRows == 0) {
            return new ArrayList<>();
        }

        // Base case: if numRows is 1, return a list with a single row [1]
        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(1));
            return result;
        }

        // Recursive call to generate the previous rows
        List<List<Integer>> prevRows = generate(numRows - 1);
        List<Integer> newRow = new ArrayList<>();

        // Initialize the new row with 1s
        for (int i = 0; i < numRows; i++) {
            newRow.add(1);
        }

        // Calculate the values for the new row based on the previous row
        for (int i = 1; i < numRows - 1; i++) {
            int value = prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i);
            newRow.set(i, value);
        }

        // Add the new row to the list of previous rows
        prevRows.add(newRow);
        return prevRows;
    }
}