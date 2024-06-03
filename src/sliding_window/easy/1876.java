package sliding_window.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
// 1876. Substrings of Size Three with Distinct Characters
class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3)
            return 0;

        Map<Character, Integer> freq = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        if (freq.size() == 3)
            cnt++;

        for (int i = 3; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - 3);

            freq.put(newChar, freq.getOrDefault(newChar, 0) + 1);

            if (freq.get(oldChar) == 1)
                freq.remove(oldChar);
            else
                freq.put(oldChar, freq.get(oldChar) - 1);

            if (freq.size() == 3)
                cnt++;

        }

        return cnt;
    }
}
