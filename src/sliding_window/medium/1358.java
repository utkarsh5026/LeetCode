package sliding_window.medium;

import java.util.*;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
// 1358. Number of Substrings Containing All Three Characters
class Solution {
    public static final int MAX_CHARACTERS = 3;

    public int numberOfSubstrings(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            while (left < s.length() && charCount.size() == MAX_CHARACTERS) {
                cnt += s.length() - i;
                char atLeft = s.charAt(left++);

                charCount.put(atLeft, charCount.get(atLeft) - 1);
                if (charCount.get(atLeft) == 0) {
                    charCount.remove(atLeft);
                    break;
                }

            }
        }

        return cnt;
    }
}