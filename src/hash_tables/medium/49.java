package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/description/
// 49. Group Anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sortedWord = new String(chars);
            anagrams.computeIfAbsent(sortedWord, k -> new ArrayList<>());
            anagrams.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagrams.values());
    }
}
