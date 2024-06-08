package hash_tables.easy;

import java.util.*;

// https:// leetcode.com/problems/minimize-string-length/description/
// 2716. Minimize String Length
class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> uniqueCharacters = new HashSet<>();

        for (char c : s.toCharArray()) {
            uniqueCharacters.add(c);
        }

        return uniqueCharacters.size();
    }
}