package sliding_window.medium;

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
// 395. Longest Substring with At Least K Repeating Characters
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return longestSubstringHelper(s, k, 0, s.length());
    }

    private int longestSubstringHelper(String s, int k, int start, int end) {
        if (end - start < k) {
            return 0;
        }

        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {

                int left = longestSubstringHelper(s, k, start, i);
                int right = longestSubstringHelper(s, k, i + 1, end);
                return Math.max(left, right);
            }
        }

        return end - start;
    }

}
