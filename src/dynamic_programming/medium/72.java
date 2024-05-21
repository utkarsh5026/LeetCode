package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/edit-distance/description/
// 72. Edit Distance
class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, word1, word2, dp);
    }

    int solve(int i, int j, String word1, String word2, int[][] dp) {
        if (i == word1.length())
            return word2.length() - j;

        if (j == word2.length())
            return word1.length() - i;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = solve(i + 1, j + 1, word1, word2, dp);
        } else {
            int insert = solve(i, j + 1, word1, word2, dp);
            int delete = solve(i + 1, j, word1, word2, dp);
            int replace = solve(i + 1, j + 1, word1, word2, dp);

            dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j];
    }
}
