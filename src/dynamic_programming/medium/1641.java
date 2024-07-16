package dynamic_programming.medium;

import java.util.Arrays;

// https://leetcode.com/problems/count-sorted-vowel-strings/description/
// 1641. Count Sorted Vowel Strings
class Solution {
    private static final String VOWELS = "aeiou";

    public int countVowelStrings(int n) {
        int[][] memo = new int[VOWELS.length()][n + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return solve(0, 0, n, memo);
    }

    int solve(int idx, int currSize, int size, int[][] memo) {
        if (currSize > size)
            return 0;

        if (memo[idx][currSize] != -1)
            return memo[idx][currSize];
        if (currSize == size)
            return 1;

        int cnt = 0;
        for (int i = idx; i < VOWELS.length(); i++) {
            cnt += solve(i, currSize + 1, size, memo);
        }

        memo[idx][currSize] = cnt;
        return cnt;
    }
}