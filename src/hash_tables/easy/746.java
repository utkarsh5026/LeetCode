package hash_tables.easy;

// https://leetcode.com/problems/min-cost-climbing-stairs/description/
// 746. Min Cost Climbing Stairs
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        // Initialize the memoization array with -1 to indicate uncomputed values
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return Math.min(minCost(n - 1, cost, dp), minCost(n - 2, cost, dp));
    }

    int minCost(int i, int[] cost, int[] dp) {
        // Base cases
        if (i < 0)
            return 0;
        if (i == 0 || i == 1)
            return cost[i];

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(minCost(i - 1, cost, dp), minCost(i - 2, cost, dp));

        return dp[i];
    }

}
