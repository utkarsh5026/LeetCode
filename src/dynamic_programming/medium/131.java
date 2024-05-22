package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/palindrome-partitioning/description/
// 131. Palindrome Partitioning
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> palindromes = new ArrayList<>();
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        generatePalindrome(0, s.length(), s, dp, palindromes, null);
        return palindromes;
    }

    void generatePalindrome(int start, int end, String s, int[][] dp, List<List<String>> palindromes,
            List<String> subparts) {

        if (start >= end)
            palindromes.add(new ArrayList<>(subparts));

        for (int i = start; i < end; i++) {
            boolean palindrome = isPalindrome(start, i, s, dp);
            if (!palindrome)
                continue;

            subparts.add(s.substring(start, i + 1));
            generatePalindrome(i + 1, end, s, dp, palindromes, subparts);
            subparts.remove(subparts.size() - 1);
        }
    }

    boolean isPalindrome(int left, int right, String s, int[][] dp) {

        if (dp[left][right] != -1)
            return dp[left][right] == 1;

        if (left >= right)
            dp[left][right] = 1;
        else if (s.charAt(left) == s.charAt(right)) {
            boolean palindrome = isPalindrome(left + 1, right - 1, s, dp);
            dp[left][right] = palindrome ? 1 : 0;
        } else {
            dp[left][right] = 0;
        }

        return dp[left][right] == 1;
    }
}