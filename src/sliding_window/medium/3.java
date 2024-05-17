package sliding_window.medium;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// 3. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIdxMap = new HashMap<>();

        int substart = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            boolean isNewChar = !charIdxMap.containsKey(curr) || charIdxMap.get(curr) < substart;

            if (isNewChar) {
                charIdxMap.put(curr, i);
                continue;
            }

            int lastOccur = charIdxMap.get(curr);
            maxLength = Math.max(maxLength, i - substart);
            charIdxMap.put(curr, i);
            substart = lastOccur + 1;
        }

        maxLength = Math.max(maxLength, s.length() - substart);
        return maxLength;
    }
}