package dynamic_programming.medium;

import java.util.Arrays;

// https://leetcode.com/problems/2-keys-keyboard/description/
// 650. 2 Keys Keyboard
class Solution {

    private int[][] dp;

    public int minSteps(int n) {
        // Base case: if n == 1, no steps are needed
        if (n == 1) {
            return 0;
        }

        dp = new int[1001][1001];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minKeyPress(1, 1, 1, n);
    }

    private int minKeyPress(int step, int value, int copy, int n) {

        if (step > n || value > n) {
            return Integer.MAX_VALUE;
        }

        // Reached target value, so return step
        if (value == n) {
            return step;
        }

        // Return pre-calculated value if available
        if (dp[step][value] != -1) {
            return dp[step][value];
        }

        dp[step][value] = Math.min(minKeyPress(step + 1, value + copy, copy, n),
                minKeyPress(step + 2, 2 * value, value, n));

        return dp[step][value];
    }
}
