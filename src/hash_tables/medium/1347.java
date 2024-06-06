package hash_tables.medium;

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
// 1347. Minimum Number of Steps to Make Two Strings Anagram
class Solution {
    public int minSteps(String s, String t) {
        int[] charCountS = new int[26];
        int[] charCountT = new int[26];

        for (char ch : s.toCharArray()) {
            charCountS[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            charCountT[ch - 'a']++;
        }

        int steps = 0;
        for (int i = 0; i < 26; i++) {
            if (charCountS[i] > charCountT[i]) {
                steps += charCountS[i] - charCountT[i];
            }
        }

        return steps;
    }
}