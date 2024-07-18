package dynamic_programming.medium;


// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
// 673. Number of Longest Increasing Subsequence
class Solution {
    private int[] nums;
    private int n;
    private Integer[] maxLengthMemo;
    private Integer[][] countMemo;

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        this.nums = nums;
        this.n = nums.length;
        this.maxLengthMemo = new Integer[n];
        this.countMemo = new Integer[n][n + 1];

        // Step 1: Find the maximum length of increasing subsequence
        int maxLen = 0;
        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
            int currMaxLength = maxLength(i);
            lengths[i] = currMaxLength;
            maxLen = Math.max(maxLen, currMaxLength);
        }

        // Step 2: Count the number of subsequences with maximum length
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLen) {
                result += countMaxLength(i, maxLen);
            }
        }

        return result;
    }

    private int maxLength(int index) {
        if (maxLengthMemo[index] != null) {
            return maxLengthMemo[index];
        }

        int max = 1;
        for (int i = index + 1; i < n; i++) {
            if (nums[i] > nums[index]) {
                max = Math.max(max, 1 + maxLength(i));
            }
        }

        maxLengthMemo[index] = max;
        return max;
    }

    private int countMaxLength(int index, int length) {
        if (length == 1) {
            return 1;
        }

        if (countMemo[index][length] != null) {
            return countMemo[index][length];
        }

        int count = 0;
        for (int i = index + 1; i < n; i++) {
            if (nums[i] > nums[index] && maxLength(i) == length - 1) {
                count += countMaxLength(i, length - 1);
            }
        }

        countMemo[index][length] = count;
        return count;
    }
}