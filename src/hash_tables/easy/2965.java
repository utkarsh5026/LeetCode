package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/find-missing-and-repeated-values/description/
// 2965. Find Missing and Repeated Values
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int n2 = n * n;
        Set<Integer> seen = new HashSet<>();
        int actualSum = 0;
        int repeatingValue = -1;

        // Calculate the actual sum and find the repeating number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                actualSum += num;
                if (seen.contains(num)) {
                    repeatingValue = num;
                } else {
                    seen.add(num);
                }
            }
        }

        // Calculate the expected sum of numbers from 1 to n^2
        int expectedSum = n2 * (n2 + 1) / 2;

        // Calculate the missing value
        int missingValue = expectedSum - (actualSum - repeatingValue);

        return new int[] { repeatingValue, missingValue };
    }
}