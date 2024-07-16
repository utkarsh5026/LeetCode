package dynamic_programming.medium;

import java.util.Arrays;

// https://leetcode.com/problems/stone-game/description/
// 877. Stone Game
class Solution {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        stoneGameHelper(true, piles, 0, piles.length - 1, dp);

        return dp[0][n - 1] > 0;
    }

    private int stoneGameHelper(boolean isAlice, int[] piles, int start, int end, int[][] dp) {
        if (start > end)
            return 0;

        if (start == end)
            return piles[start];

        if (dp[start][end] != -1)
            return dp[start][end];

        int stones;
        if (isAlice) {
            stones = Math.max(piles[start] + stoneGameHelper(false, piles, start + 1, end, dp),
                    piles[end] + stoneGameHelper(false, piles, start, end - 1, dp));
        } else {
            stones = Math.min(-piles[start] + stoneGameHelper(true, piles, start + 1, end, dp),
                    -piles[end] + stoneGameHelper(true, piles, start, end - 1, dp));
        }
        dp[start][end] = stones;
        return stones;
    }

}
