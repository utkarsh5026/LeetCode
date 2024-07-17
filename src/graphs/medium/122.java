package graphs.medium;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
// 122. Best Time to Buy and Sell Stock II
class Solution {

    private static final int BUY = 1;
    private static final int SELL = 0;

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return solve(0, BUY, prices, 0, dp);
    }

    int solve(int day, int buy, int[] prices, int profit, int[][] dp) {
        if (day == prices.length)
            return profit;

        if (dp[day][buy] != Integer.MIN_VALUE)
            return dp[day][buy];

        int curr = prices[day];
        if (buy == BUY) {
            int bought = solve(day + 1, SELL, prices, profit - curr, dp);
            int skip = solve(day + 1, BUY, prices, profit, dp);
            dp[day][buy] = Math.max(bought, skip);
            return Math.max(bought, skip);
        } else {
            int sold = solve(day + 1, BUY, prices, profit + curr, dp);
            int skip = solve(day + 1, SELL, prices, profit, dp);
            dp[day][buy] = Math.max(sold, skip);
            return Math.max(sold, skip);
        }
    }
}