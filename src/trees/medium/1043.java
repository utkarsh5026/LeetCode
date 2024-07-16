package trees.medium;

import java.util.*;

// https://leetcode.com/problems/partition-array-for-maximum-sum/description/
// 1043. Partition Array for Maximum Sum
class Solution {
    private int[] arr;
    private int k;
    private int[][] max;
    private int[] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        this.max = new int[arr.length][arr.length];
        this.memo = new int[arr.length];
        Arrays.fill(memo, -1);

        // Precompute max values
        for (int i = 0; i < arr.length; i++) {
            int currMax = 0;
            for (int j = i; j < Math.min(arr.length, i + k); j++) {
                currMax = Math.max(currMax, arr[j]);
                max[i][j] = currMax;
            }
        }

        return solve(0);
    }

    private int solve(int start) {
        if (start >= arr.length)
            return 0;

        if (memo[start] != -1)
            return memo[start];

        int maxSum = 0;
        for (int i = 1; i <= k && start + i - 1 < arr.length; i++) {
            int end = start + i - 1;
            int subMax = max[start][end];
            maxSum = Math.max((subMax * i) + solve(start + i), maxSum);
        }

        memo[start] = maxSum;
        return maxSum;
    }
}