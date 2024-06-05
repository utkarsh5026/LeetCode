package sliding_window.easy;

import java.util.*;

// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences
// 3090. Maximum Length Substring With Two Occurrences
class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (containsMoreThanTwo(freq)) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }

    private boolean containsMoreThanTwo(Map<Character, Integer> freq) {
        for (int count : freq.values()) {
            if (count > 2) {
                return true;
            }
        }
        return false;
    }
}
