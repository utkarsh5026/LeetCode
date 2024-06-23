package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/description/
// 2186. Minimum Number of Steps to Make Two Strings Anagram II
class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> target = makeFreqMap(s);
        Map<Character, Integer> curr = makeFreqMap(t);

        Set<Character> charSet = new HashSet<>();
        charSet.addAll(target.keySet());
        charSet.addAll(curr.keySet());

        int steps = 0;
        for (char ch : charSet) {
            int charDiff = Math.abs(curr.getOrDefault(ch, 0) - target.getOrDefault(ch, 0));
            steps += charDiff;
        }

        return steps;
    }

    Map<Character, Integer> makeFreqMap(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }
}