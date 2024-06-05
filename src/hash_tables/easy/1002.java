package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/find-common-characters/description/
// 1002. Find Common Characters
class Solution {
    public List<String> commonChars(String[] words) {
        List<Map<Character, Integer>> frequencies = new ArrayList<>();
        Set<Character> allChars = new HashSet<>();
        for (String word : words) {
            Map<Character, Integer> frequency = new HashMap<>();
            for (char ch : word.toCharArray()) {
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
                allChars.add(ch);
            }

            frequencies.add(frequency);
        }
        return findCommonChars(frequencies, allChars);
    }

    List<String> findCommonChars(List<Map<Character, Integer>> frequencies, Set<Character> allChars) {

        List<String> common = new ArrayList<>();
        for (char ch : allChars) {
            int cnt = Integer.MAX_VALUE;
            for (Map<Character, Integer> freq : frequencies) {

                cnt = Math.min(cnt, freq.getOrDefault(ch, 0));
            }

            for (int i = 0; i < cnt; i++) {
                common.add(Character.toString(ch));
            }
        }

        return common;
    }
}
