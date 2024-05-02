package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/word-pattern/description/
// 290. Word Pattern
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        String[] words = s.split("\\s+");
        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char patChar = pattern.charAt(i);
            String word = words[i];

            if (charMap.containsKey(patChar) && !charMap.get(patChar).equals(word))
                return false;

            if (wordMap.containsKey(word) && !wordMap.get(word).equals(patChar))
                return false;
            charMap.put(patChar, word);
            wordMap.put(word, patChar);
        }

        return true;
    }
}