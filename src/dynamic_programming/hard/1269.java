package dynamic_programming.hard;

// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/
// 1269. Number of Ways to Stay in the Same Place After Some Steps
class Solution {
    private static final int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        int maxPos = Math.min(arrLen, steps + 1);
        long[][] dp = new long[steps + 1][maxPos];

        // Initialize the starting position
        dp[0][0] = 1;

        // Fill the DP table
        for (int step = 1; step <= steps; step++) {
            for (int pos = 0; pos < maxPos; pos++) {
                // Stay in the same position
                dp[step][pos] += dp[step - 1][pos];
                dp[step][pos] %= MOD;

                // Move to the left
                if (pos - 1 >= 0) {
                    dp[step][pos] += dp[step - 1][pos - 1];
                    dp[step][pos] %= MOD;
                }

                // Move to the right
                if (pos + 1 < maxPos) {
                    dp[step][pos] += dp[step - 1][pos + 1];
                    dp[step][pos] %= MOD;
                }
            }
        }

        return (int) dp[steps][0];
    }


}
