package dynamic_programming.easy;

import java.util.*;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// 121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return solve(prices.length - 1, prices, dp);
    }

    int solve(int day, int[] prices, int[] dp) {

        if (day < 0)
            return 0;

        if (dp[day] != -1)
            return dp[day];

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i <= day; i++) {
            minPrice = Math.min(prices[i], minPrice);

            maxProfit = Math.max(maxProfit, prices[day] - minPrice);
        }

        dp[day] = Math.max(maxProfit, solve(day - 1, prices, dp));
        return dp[day];
    }
}
