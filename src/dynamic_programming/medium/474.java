package dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/ones-and-zeroes/description/
// 474. Ones and Zeroes
class Solution {

    class OneZero {
        int ones;
        int zeros;

        public OneZero(int ones, int zeros) {
            this.ones = ones;
            this.zeros = zeros;
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        List<OneZero> reps = new ArrayList<>();
        for (String str : strs) {
            int ones = 0;
            int zeros = 0;

            for (char ch : str.toCharArray()) {
                if (ch == '0')
                    zeros++;
                else
                    ones++;
            }

            reps.add(new OneZero(ones, zeros));
        }

        // Initialize memoization array
        int[][][] memo = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        return solve(0, reps, 0, 0, m, n, memo);
    }

    int solve(int idx, List<OneZero> reps, int zeroCnt, int oneCnt, int zeroLimit, int oneLimit, int[][][] memo) {

        if (idx == reps.size())
            return 0;

        // Check if result is already computed
        if (memo[idx][zeroCnt][oneCnt] != -1) {
            return memo[idx][zeroCnt][oneCnt];
        }

        OneZero curr = reps.get(idx);

        int take = Integer.MIN_VALUE;
        int skip = solve(idx + 1, reps, zeroCnt, oneCnt, zeroLimit, oneLimit, memo);
        if (curr.zeros + zeroCnt <= zeroLimit && curr.ones + oneCnt <= oneLimit) {
            take = 1 + solve(idx + 1, reps, zeroCnt + curr.zeros, oneCnt + curr.ones, zeroLimit, oneLimit, memo);
        }

        // Store the result in the memo array
        memo[idx][zeroCnt][oneCnt] = Math.max(take, skip);
        return memo[idx][zeroCnt][oneCnt];
    }
}
