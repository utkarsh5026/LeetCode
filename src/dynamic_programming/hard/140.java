package dynamic_programming.hard;

import java.util.*;

// https://leetcode.com/problems/word-break-ii/description/
/// 140. Word Break II
class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        return backtrack(s, wordSet, new HashMap<>());
    }

    List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s))
            return memo.get(s);

        List<String> breaks = new ArrayList<>();

        if (s.isEmpty()) {
            breaks.add("");
            return breaks;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> result = backtrack(suffix, wordSet, memo);

                for (String suf : result) {
                    String delimeter = suf.isEmpty() ? "" : " ";
                    breaks.add(prefix + delimeter + suf);
                }
            }
        }

        memo.put(s, breaks);
        return breaks;
    }
}