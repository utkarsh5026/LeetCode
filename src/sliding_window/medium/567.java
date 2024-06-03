package sliding_window.medium;

import java.util.*;

// https://leetcode.com/problems/permutation-in-string/description/
// 567. Permutation in String
class Solution {
    public boolean checkInclusion(String s2, String s1) {

        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : s2.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);

            if (!frequency.containsKey(ch) || s1.length() - i < s2.length())
                continue;

            Map<Character, Integer> window = new HashMap<>();

            for (int j = 0; j < s2.length(); j++) {
                char c = s1.charAt(i + j);
                if (!frequency.containsKey(c))
                    break;

                window.put(c, window.getOrDefault(c, 0) + 1);
            }

            if (window.keySet().size() == frequency.keySet().size() && haveSameFreq(frequency, window))
                return true;
        }

        return false;
    }

    boolean haveSameFreq(Map<Character, Integer> target, Map<Character, Integer> curr) {
        for (Map.Entry<Character, Integer> frequency : curr.entrySet()) {
            char ch = frequency.getKey();
            int cnt = frequency.getValue();

            if (!target.containsKey(ch))
                return false;

            if (target.get(ch) != cnt)
                return false;
        }

        return true;
    }
}