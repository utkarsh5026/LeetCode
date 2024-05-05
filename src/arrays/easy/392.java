package arrays.easy;

// https://leetcode.com/problems/is-subsequence/description/
// 392. Is Subsequence
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0;
        int tIdx = 0;

        while (sIdx < s.length() && tIdx < t.length()) {
            char sChar = s.charAt(sIdx);
            char tChar = t.charAt(tIdx);

            System.out.println(sChar + " " + tChar);
            if (tChar == sChar)
                sIdx++;
            tIdx++;
        }

        System.out.println(tIdx);
        return sIdx == s.length();
    }
}