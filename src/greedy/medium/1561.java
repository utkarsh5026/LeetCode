package greedy.medium;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/
// 1561. Maximum Number of Coins You Can Get
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int maxCoins = 0;

        // Pick the second largest pile in each group of three
        for (int i = 0; i < n; i++) {
            maxCoins += piles[piles.length - 2 * (i + 1)];
        }

        return maxCoins;
    }
}
