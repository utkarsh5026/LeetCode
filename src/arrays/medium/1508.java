package arrays.medium;

import java.util.*;

// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/
// 1508. Range Sum of Sorted Subarray Sums
class Solution {
    private static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                sums.add(currSum);
            }
        }

        Collections.sort(sums);
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += sums.get(i - 1) % MOD;
        }

        return sum;
    }
}