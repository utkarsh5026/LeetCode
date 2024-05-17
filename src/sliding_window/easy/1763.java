package sliding_window.easy;

import java.util.*;

// https://leetcode.com/problems/longest-nice-substring/description/
// 1763. Longest Nice Substring
class Solution {
    public String longestNiceSubstring(String s) {
        int maxLength = 0;
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            Set<Character> lower = new HashSet<>();
            Set<Character> upper = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char curr = s.charAt(j);
                if (Character.isLowerCase(curr))
                    lower.add(curr);
                else if (Character.isUpperCase(curr))
                    upper.add(curr);

                if (!isNice(lower, upper))
                    continue;

                int currLength = j - i + 1;
                if (currLength > maxLength) {
                    maxLength = currLength;
                    longest = s.substring(i, j + 1);
                }
            }
        }

        return longest;
    }

    boolean isNice(Set<Character> lower, Set<Character> upper) {
        if (lower.size() != upper.size())
            return false;

        for (char c : lower) {
            if (!upper.contains(Character.toUpperCase(c)))
                return false;
        }

        return true;
    }
}
