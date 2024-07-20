package dynamic_programming.hard;

// https://leetcode.com/problems/count-vowels-permutation/description/
// 1220. Count Vowels Permutation
class Solution {
    private static final int MOD = 1000000007;
    private Long[][] memo;

    public int countVowelPermutation(int n) {
        memo = new Long[n + 1][5];
        long result = 0;

        // Initialize the result by summing up all the ways to start with each vowel
        for (int i = 0; i < 5; i++) {
            result = (result + countWays(n - 1, i)) % MOD;
        }

        return (int) result;
    }

    private long countWays(int pos, int vowel) {
        if (pos == 0) {
            return 1;
        }

        if (memo[pos][vowel] != null) {
            return memo[pos][vowel];
        }

        long count = 0;

        switch (vowel) {
            case 0: // 'a' -> 'e'
                count = countWays(pos - 1, 1);
                break;
            case 1: // 'e' -> 'a' or 'i'
                count = (countWays(pos - 1, 0) + countWays(pos - 1, 2)) % MOD;
                break;
            case 2: // 'i' -> 'a', 'e', 'o', or 'u'
                count = (countWays(pos - 1, 0) + countWays(pos - 1, 1) + countWays(pos - 1, 3) + countWays(pos - 1, 4)) % MOD;
                break;
            case 3: // 'o' -> 'i' or 'u'
                count = (countWays(pos - 1, 2) + countWays(pos - 1, 4)) % MOD;
                break;
            case 4: // 'u' -> 'a'
                count = countWays(pos - 1, 0);
                break;
        }

        memo[pos][vowel] = count;
        return count;
    }

}
