package strings.easy;

// https://leetcode.com/problems/excel-sheet-column-title/description/
// 168. Excel Sheet Column Title
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            char c = (char) ('A' + (columnNumber % 26));
            title.append(c);
            columnNumber /= 26;
        }

        return title.reverse().toString();
    }
}