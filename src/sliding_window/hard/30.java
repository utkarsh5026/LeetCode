package sliding_window.hard;

import java.util.*;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
// 30. Substring with Concatenation of All Words
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();

        if (s.isEmpty() || words.length == 0)
            return indices;

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;

            Map<String, Integer> currCount = new HashMap<>();
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;


                if (wordCount.containsKey(word)) {
                    currCount.put(word, currCount.getOrDefault(word, 0) + 1);


                    while (currCount.get(word) > wordCount.get(word)){
                        String leftWord = s.substring(left, left + wordLength);
                        currCount.put(leftWord, currCount.get(leftWord) - 1);
                        left += wordLength;
                    }

                    if (right - left == totalLength) indices.add(left);
                } else {
                    currCount.clear();
                    left = right;
                }
            }
        }

        return indices;
    }
}