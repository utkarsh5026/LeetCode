package sliding_window.medium;

import java.util.*;

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
// 718. Maximum Length of Repeated Subarray
class Solution {
    private int[][] memo;

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLength = Math.max(maxLength, dfs(nums1, nums2, i, j));
            }
        }
        return maxLength;
    }

    private int dfs(int[] nums1, int[] nums2, int i, int j) {
        if (i >= nums1.length || j >= nums2.length)
            return 0; // Base case
        if (memo[i][j] != -1)
            return memo[i][j];
        memo[i][j] = 0;
        if (nums1[i] == nums2[j]) {
            memo[i][j] = 1 + dfs(nums1, nums2, i + 1, j + 1); // Recursively match the rest
        }

        return memo[i][j];
    }
}
