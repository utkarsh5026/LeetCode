package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/find-and-replace-pattern/description/
// 890. Find and Replace Pattern
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> match = new ArrayList<>();
        Map<Character, Integer> target = makeCharMap(pattern);

        for (String word : words) {
            if (word.length() != pattern.length())
                continue;

            Map<Character, Integer> charCount = makeCharMap(word);
            if (followsSamePattern(target, charCount, pattern, word))
                match.add(word);
        }
        return match;
    }

    Map<Character, Integer> makeCharMap(String word) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : word.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        return cnt;
    }

    boolean followsSamePattern(Map<Character, Integer> target, Map<Character, Integer> current, String targetString,
            String currString) {

        Map<Character, Character> follow = new HashMap<>();

        for (int i = 0; i < currString.length(); i++) {
            char currCh = currString.charAt(i);
            char targetCh = targetString.charAt(i);

            if (!Objects.equals(current.get(currCh), target.get(targetCh)))
                return false;

            if (follow.containsKey(currCh) && follow.get(currCh) != targetCh)
                return false;

            follow.put(currCh, targetCh);
        }
        return true;
    }
}