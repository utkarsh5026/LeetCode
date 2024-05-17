package sliding_window.medium;

import java.util.*;

// https:// leetcode.com/problems/find-all-anagrams-in-a-string/description/
// 438. Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();

        Map<Character, Integer> target = makeCharMap(p);
        Map<Character, Integer> check = makeCharMap(s.substring(0, p.length()));

        List<Integer> anagramIndices = new ArrayList<>();

        if (isAnagram(check, target))
            anagramIndices.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            char curr = s.charAt(i);

            int newBeginIndex = i - p.length() + 1;
            char outside = s.charAt(newBeginIndex - 1);

            check.computeIfPresent(outside, (c, cnt) -> cnt - 1);
            if (check.get(outside) == 0)
                check.remove(outside);

            check.computeIfAbsent(curr, cnt -> 0);
            check.put(curr, check.get(curr) + 1);

            if (isAnagram(check, target))
                anagramIndices.add(newBeginIndex);
        }

        return anagramIndices;
    }

    boolean isAnagram(Map<Character, Integer> check, Map<Character, Integer> target) {
        if (check.keySet().size() != target.keySet().size())
            return false;

        for (Map.Entry<Character, Integer> pair : target.entrySet()) {
            Character targetChar = pair.getKey();
            int frequency = pair.getValue();
            if (!check.containsKey(targetChar))
                return false;

            if (frequency != check.get(targetChar))
                return false;
        }

        return true;
    }

    Map<Character, Integer> makeCharMap(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            charMap.computeIfAbsent(c, cnt -> 0);
            charMap.put(c, charMap.get(c) + 1);
        }

        return charMap;
    }
}