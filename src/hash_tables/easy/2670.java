package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/find-the-distinct-difference-array/description/
// 2670. Find the Distinct Difference Array
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] prefixCounts = new int[n];
        int[] suffixCounts = new int[n];

        Set<Integer> prefixSet = new HashSet<>();
        Set<Integer> suffixSet = new HashSet<>();

        // Calculate distinct counts for prefix
        for (int i = 0; i < n; i++) {
            prefixSet.add(nums[i]);
            prefixCounts[i] = prefixSet.size();
        }

        // Calculate distinct counts for suffix
        for (int i = n - 1; i >= 0; i--) {
            suffixSet.add(nums[i]);
            suffixCounts[i] = suffixSet.size();
        }

        // Compute the distinct difference array
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            int suffixCount = (i + 1 < n) ? suffixCounts[i + 1] : 0;
            diff[i] = prefixCounts[i] - suffixCount;
        }

        return diff;
    }
}
