package dynamic_programming.medium;

// https://leetcode.com/problems/coin-change/description/
// 322. Coin Change
class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = findMinimumCoins(coins.length - 1, coins, amount, new Integer[coins.length][amount + 1]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int findMinimumCoins(int idx, int[] coins, int amount, Integer[][] memo) {
        if (amount == 0) {
            return 0;
        }
        if (idx < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[idx][amount] != null) {
            return memo[idx][amount];
        }

        // Option 1: Take the current coin
        int takeSame = findMinimumCoins(idx, coins, amount - coins[idx], memo);
        if (takeSame != Integer.MAX_VALUE) {
            takeSame += 1;
        }

        int takeAnother = findMinimumCoins(idx - 1, coins, amount, memo);
        memo[idx][amount] = Math.min(takeSame, takeAnother);
        return memo[idx][amount];
    }
}
