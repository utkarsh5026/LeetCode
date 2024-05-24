package dynamic_programming.hard;

import java.util.*;

// https://leetcode.com/problems/maximum-score-words-formed-by-letters/description/
// 1255. Maximum Score Words Formed by Letters
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        Map<String, Integer> wordScoreMap = new HashMap<>();

        for (String word : words) {
            int wordScore = 0;
            for (int i = 0; i < word.length(); i++) {
                wordScore += score[word.charAt(i) - 'a'];
            }
            wordScoreMap.put(word, wordScore);
        }

        Map<Character, Integer> letterCount = new HashMap<>();
        for (char c : letters) {
            letterCount.computeIfAbsent(c, cnt -> 0);
            letterCount.computeIfPresent(c, (ch, cnt) -> cnt + 1);
        }

        return solve(0, words, wordScoreMap, letterCount);
    }

    int solve(int index, String[] words, Map<String, Integer> wordScoreMap, Map<Character, Integer> letterCountMap) {

        if (index == words.length)
            return 0;

        int skip = solve(index + 1, words, wordScoreMap, letterCountMap);

        String curr = words[index];

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < curr.length(); i++) {
            charCount.computeIfAbsent(curr.charAt(i), cnt -> 0);
            charCount.computeIfPresent(curr.charAt(i), (c, cnt) -> cnt + 1);
        }

        boolean canFormAWord = true;
        for (Character ch : charCount.keySet()) {
            if (letterCountMap.getOrDefault(ch, 0) < charCount.get(ch)) {
                canFormAWord = false;
                break;
            }
        }

        if (canFormAWord) {
            for (char ch : curr.toCharArray()) {
                letterCountMap.put(ch, letterCountMap.get(ch) - 1);
            }

            int take = wordScoreMap.get(curr) + solve(index + 1, words, wordScoreMap, letterCountMap);

            for (char ch : curr.toCharArray()) {
                letterCountMap.put(ch, letterCountMap.get(ch) + 1);
            }

            return Math.max(skip, take);
        }

        return skip;
    }
}