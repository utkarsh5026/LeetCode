package strings.easy;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-prefix/description/
// 14. Longest Common Prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        int first = 0;
        int last = 0;
        StringBuilder common = new StringBuilder();

        while (first < firstString.length() && last < lastString.length()) {
            char firstChar = firstString.charAt(first);
            char lastChar = lastString.charAt(last);

            if (firstChar != lastChar)
                break;

            common.append(firstChar);
            first++;
            last++;
        }

        return common.toString();
    }
}