package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/keyboard-row/description/
// 500. Keyboard Row
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        List<String> ans = new ArrayList<>();
        for (String s : words) {
            if (checkRow(s, row1) || checkRow(s, row2) || checkRow(s, row3)) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }

    private boolean checkRow(String word, Set<Character> row) {
        for (char c : word.toLowerCase().toCharArray()) {
            if (!row.contains(c)) {
                return false;
            }
        }
        return true;
    }
}