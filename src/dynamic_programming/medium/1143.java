package dynamic_programming.medium;

// https://leetcode.com/problems/longest-common-subsequence/description/
// 1143. Longest Common Subsequence
class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int k = text2.length();

        // Create a 2D array to store the lengths of LCS
        int[][] memo = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                memo[i][j] = -1;
            }
        }

        return solve(text1, text2, m - 1, k - 1, memo);
    }

    private static int solve(String text1, String text2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // If characters match, increment the count and proceed to the next characters
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + solve(text1, text2, i - 1, j - 1, memo);
        } else {
            int skipText1 = solve(text1, text2, i - 1, j, memo);
            int skipText2 = solve(text1, text2, i, j - 1, memo);
            memo[i][j] = Math.max(skipText1, skipText2);
        }

        return memo[i][j];
    }
}
