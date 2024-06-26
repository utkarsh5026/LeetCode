package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/
// 1371. Find the Longest Substring Containing Vowels in Even Countss
class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> stateToIndex = new HashMap<>();
        stateToIndex.put(0, -1);
        int currentState = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    currentState ^= 1;
                    break;
                case 'e':
                    currentState ^= 2;
                    break;
                case 'i':
                    currentState ^= 4;
                    break;
                case 'o':
                    currentState ^= 8;
                    break;
                case 'u':
                    currentState ^= 16;
                    break;
                default:
                    break;
            }

            if (stateToIndex.containsKey(currentState)) {
                maxLength = Math.max(maxLength, i - stateToIndex.get(currentState));
            } else {
                // Record the first occurrence of this state
                stateToIndex.put(currentState, i);
            }
        }

        return maxLength;

    }
}