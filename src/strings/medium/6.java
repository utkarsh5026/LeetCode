package strings.medium;

// https://leetcode.com/problems/zigzag-conversion/description/
// 6. Zigzag Conversion
class Solution {
    public String convert(String s, int numRows) {
        // If numRows is 1 or the string is shorter than numRows, no conversion is
        // needed
        if (numRows == 1 || s.length() <= numRows)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int n = s.length();
        int index = 0;

        while (index < n) {
            // Going down
            for (int i = 0; i < numRows && index < n; i++) {
                rows[i].append(s.charAt(index++));
            }

            // Going up diagonally
            for (int i = numRows - 2; i > 0 && index < n; i--) {
                rows[i].append(s.charAt(index++));
            }
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}