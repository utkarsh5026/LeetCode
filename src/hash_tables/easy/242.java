package hash_tables.easy;

// https://leetcode.com/problems/valid-anagram/description/
// 242. Valid Anagram
class Solution {
    public boolean isAnagram(String s, String t) {

        int[] chars = new int[26];
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            int scharIdx = s.charAt(i) - 'a';
            int tCharIdx = t.charAt(i) - 'a';

            chars[scharIdx]--;
            chars[tCharIdx]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0)
                return false;
        }

        return true;
    }
}