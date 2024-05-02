package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/isomorphic-strings/description/
// 205. Isomorphic Strings
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (isInvalidTrailOfCharacter(sMap, sChar, tChar) || isInvalidTrailOfCharacter(tMap, tChar, sChar))
                return false;

            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }

        return true;
    }

    private boolean isInvalidTrailOfCharacter(Map<Character, Character> charMap, char mapKey, char keyVal) {
        return charMap.containsKey(mapKey) && charMap.get(mapKey) != keyVal;
    }
}