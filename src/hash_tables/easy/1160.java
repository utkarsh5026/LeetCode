package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/
// 1160. Find Words That Can Be Formed by Characterss
class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> freq = makeCharMap(chars);
        int length = 0;

        for (String word : words) {
            if (canFormWord(makeCharMap(word), freq))
                length += word.length();
        }
        return length;
    }

    Map<Character, Integer> makeCharMap(String chars) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }

    boolean canFormWord(Map<Character, Integer> curr, Map<Character, Integer> target) {
        for (Map.Entry<Character, Integer> cnt : curr.entrySet()) {
            char ch = cnt.getKey();
            int frequency = cnt.getValue();

            if (target.getOrDefault(ch, 0) <= frequency) {
                return false;
            }
        }

        return true;
    }

}