package dynamic_programming.hard;

import java.util.Arrays;

// https://leetcode.com/problems/reducing-dishes/description/
// 1402. Reducing Dishes
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] memo = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return solve(0, 1, satisfaction, memo);
    }

    int solve(int start, int time, int[] satisfaction, int[][] memo) {
        if (start == satisfaction.length)
            return 0;

        if (memo[start][time] != Integer.MIN_VALUE)
            return memo[start][time];

        int take = satisfaction[start] * time + solve(start + 1, time + 1, satisfaction, memo);
        int skip = solve(start + 1, time, satisfaction, memo);

        memo[start][time] = Math.max(take, skip);
        return memo[start][time];
    }
}