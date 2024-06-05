package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/permutation-difference-between-two-strings/description/
// 3146. Permutation Difference between Two Strings
class Solution {
    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            indexMap.put(t.charAt(i), i);
        }

        int permutationDiff = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int indexInT = indexMap.get(ch);
            permutationDiff += Math.abs(i - indexInT);
        }

        return permutationDiff;
    }
}
