package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/count-pairs-of-similar-strings/description/
// 2506. Count Pairs Of Similar Strings
class Solution {
    public int similarPairs(String[] words) {
        List<Set<Character>> wordSet = new ArrayList<>();
        for (String word : words) {
            Set<Character> chars = new HashSet<>();
            for (char ch : word.toCharArray()) {
                chars.add(ch);
            }
            wordSet.add(chars);
        }

        int pairs = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> target = wordSet.get(i);
            for (int j = i + 1; j < words.length; j++) {
                if (target.equals(wordSet.get(j)))
                    pairs++;
            }
        }

        return pairs;
    }
}