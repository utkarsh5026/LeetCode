package hash_tables.easy;

// https://leetcode.com/problems/n-th-tribonacci-number/description/
// 1137. N-th Tribonacci Number
class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        return tribonacciHelper(n, dp);
    }

    int tribonacciHelper(int n, int[] dp) {
        // Base cases
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = tribonacciHelper(n - 1, dp) + tribonacciHelper(n - 2, dp) + tribonacciHelper(n - 3, dp);

        return dp[n];
    }

}
