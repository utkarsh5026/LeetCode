package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/custom-sort-string/description/
// 791. Custom Sort String
class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            charMap.put(order.charAt(i), i);
        }

        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        Collections.sort(chars, (a, b) -> {
            if (charMap.containsKey(a) && charMap.containsKey(b))
                return charMap.get(a) - charMap.get(b);

            if (charMap.containsKey(a))
                return -1;

            if (charMap.containsKey(b))
                return 1;

            return Character.compare(a, b);
        });

        StringBuilder sorted = new StringBuilder();
        for (Character c : chars) {
            sorted.append(c);
        }

        return sorted.toString();
    }
}