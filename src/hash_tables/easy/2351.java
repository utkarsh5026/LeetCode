package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/first-letter-to-appear-twice/description/
// 2351. First Letter to Appear Twice
class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }

        // This line should never be reached because the problem guarantees
        // that there is at least one letter that appears twice
        return '\0';
    }
}
