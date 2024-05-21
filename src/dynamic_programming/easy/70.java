package dynamic_programming.easy;

// https://leetcode.com/problems/climbing-stairs/description/
// 70. Climbing Stairs
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        solve(n, dp);
        return dp[n];
    }

    private int solve(int stair, int[] dp) {
        if (stair == 0)
            return 0;

        int oneBefore = stair - 1 >= 0 ? 1 + solve(stair - 1, dp) : 0;
        int twoBefore = stair - 2 >= 0 ? 1 + solve(stair - 2, dp) : 0;

        dp[stair] = oneBefore + twoBefore;
        return dp[stair];
    }
}
