package dynamic_programming.medium;

import java.util.Arrays;

// https://leetcode.com/problems/interleaving-string/description/
// 97. Interleaving String
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, 0, s1, s2, s3, dp);
    }

    boolean solve(int s1i, int s2j, int s3k, String s1, String s2, String s3, int[][] dp) {
        if (s1i == s1.length() && s2j == s2.length() && s3k == s3.length()) {
            return true;
        }

        if (dp[s1i][s2j] != -1) {
            return dp[s1i][s2j] == 1;
        }

        boolean interleaved = false;
        if (s1i < s1.length() && s1.charAt(s1i) == s3.charAt(s3k)) {
            interleaved = solve(s1i + 1, s2j, s3k + 1, s1, s2, s3, dp);
        }

        if (!interleaved && s2j < s2.length() && s2.charAt(s2j) == s3.charAt(s3k)) {
            interleaved = solve(s1i, s2j + 1, s3k + 1, s1, s2, s3, dp);
        }

        dp[s1i][s2j] = interleaved ? 1 : 0;
        return interleaved;
    }
}
