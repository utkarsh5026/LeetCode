package greedy.easy;

import java.util.HashMap;
import java.util.Map;

// https:// leetcode.com/problems/longest-palindrome/description/
// 409. Longest Palindrome

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int maxLength = 0;
        boolean oddFound = false;

        for (int count : freq.values()) {
            if (count % 2 == 0) {
                maxLength += count;
            } else {
                maxLength += count - 1;
                oddFound = true;
            }
        }

        if (oddFound) {
            maxLength += 1;
        }

        return maxLength;
    }
}
