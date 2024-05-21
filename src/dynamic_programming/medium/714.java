package dynamic_programming.medium;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
// 714. Best Time to Buy and Sell Stock with Transaction Fee
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0)
            return 0;

        // Create a 2D DP array for memoization
        int[][] dp = new int[n][2];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        // Start the recursion with initial state: day 0, not holding any stock
        return maxProfitHelper(prices, fee, 0, 0, dp);
    }

    int maxProfitHelper(int[] prices, int fee, int day, int holding, int[][] dp) {
        if (day == prices.length) {
            return 0;
        }

        // Check if the result is already computed
        if (dp[day][holding] != -1) {
            return dp[day][holding];
        }

        int doNothing = maxProfitHelper(prices, fee, day + 1, holding, dp);

        int doSomething;
        if (holding == 1) {
            // If we are holding a stock, we can sell it
            doSomething = prices[day] - fee + maxProfitHelper(prices, fee, day + 1, 0, dp);
        } else {
            // If we are not holding a stock, we can buy it
            doSomething = -prices[day] + maxProfitHelper(prices, fee, day + 1, 1, dp);
        }

        int result = Math.max(doNothing, doSomething);
        dp[day][holding] = result;

        return result;
    }
}
