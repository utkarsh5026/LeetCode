package dynamic_programming.medium;

import java.util.*;

// https://leetcode.com/problems/word-break/description/
// 139. Word Break
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return canBreakWord(0, s, wordSet, memo);
    }

    boolean canBreakWord(int start, String word, Set<String> wordSet, Boolean[] memo) {
        if (start == word.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= word.length(); end++) {
            String wordTill = word.substring(start, end);
            if (wordSet.contains(wordTill) && canBreakWord(end, word, wordSet, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
}
