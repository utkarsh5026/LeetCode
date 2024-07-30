package dynamic_programming.medium;

// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/
// 1653. Minimum Deletions to Make String Balanced
class Solution {
    public int minimumDeletions(String s) {
        int l = s.length();
        // dp stores number of chars to remove to make s.substring(0, i) valid
        int[] dp = new int[l + 1];
        int bcount = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'a') {
                dp[i + 1] = Math.min(dp[i] + 1, bcount);
            } else {
                dp[i + 1] = dp[i];
                bcount++;
            }
        }

        return dp[l];
    }
}