package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/
// 1941. Check if All Characters Have Equal Number of Occurrences
class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> countMap = new HashMap<>();

        // Count occurrences of each character
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Get the frequency of the first character
        int firstCount = countMap.get(s.charAt(0));

        // Check if all frequencies are the same
        for (int count : countMap.values()) {
            if (count != firstCount) {
                return false;
            }
        }

        return true;
    }
}