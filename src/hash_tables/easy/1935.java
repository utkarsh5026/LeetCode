package hash_tables.easy;

import java.util.*;

// https:// leetcode.com/problems/maximum-number-of-words-you-can-type/description/
// 1935. Maximum Number of Words You Can Type
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> brokenSet = new HashSet<>();

        // Add each broken letter to the set
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }

        int count = 0;

        // Check each word to see if it contains any broken letters
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) {
                    canType = false;
                    break;
                }
            }
            if (canType) {
                count++;
            }
        }

        return count;
    }
}