package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/count-common-words-with-one-occurrence/description/
// 2085. Count Common Words With One Occurrence
class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> words1Cnt = makeWordCnt(words1);
        Map<String, Integer> words2Cnt = makeWordCnt(words2);

        int exactlyOne = 0;

        for (Map.Entry<String, Integer> cnt : words1Cnt.entrySet()) {
            int freq = cnt.getValue();
            String word = cnt.getKey();
            if (freq == 1 && (words2Cnt.getOrDefault(word, 0) == freq)) {
                exactlyOne++;
            }
        }
        return exactlyOne;
    }

    Map<String, Integer> makeWordCnt(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        return cnt;
    }
}