package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/longest-palindromic-substring/description/
// 5. Longest Palindromic Substring
class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();
        if (size <= 1)
            return s;

        int[][] dp = new int[size][size];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (isPalindrome(i, j, s, dp)) {
                    int length = j - i + 1;

                    if (length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    boolean isPalindrome(int left, int right, String s, int[][] dp) {
        if (dp[left][right] != -1)
            return dp[left][right] == 1;

        if (left >= right)
            return true;

        if (s.charAt(left) != s.charAt(right)) {
            dp[left][right] = 0;
            return false;
        }

        boolean palindromeFound = isPalindrome(left + 1, right - 1, s, dp);
        dp[left][right] = palindromeFound ? 1 : 0;
        return palindromeFound;
    }
}
