package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/ransom-note/description/
// 383. Ransom Note
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = createMagazineMap(magazine);

        for (int i = 0; i < ransomNote.length(); i++) {
            char curr = ransomNote.charAt(i);

            if (!magazineMap.containsKey(curr))
                return false;
            if (magazineMap.get(curr) == 0)
                return false;

            magazineMap.put(curr, magazineMap.get(curr) - 1);
        }
        return true;
    }

    private Map<Character, Integer> createMagazineMap(String magazine) {
        Map<Character, Integer> magazineAlphabets = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char curr = magazine.charAt(i);
            magazineAlphabets.computeIfAbsent(curr, k -> 0);
            magazineAlphabets.put(curr, magazineAlphabets.get(curr) + 1);
        }
        return magazineAlphabets;
    }
}