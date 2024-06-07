package hash_tables.easy;

import java.util.*;

// https:// leetcode.com/problems/check-if-the-sentence-is-pangram/description/
// 1832. Check if the Sentence Is Pangram

class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }

            if (letters.size() == 26)
                return true;
        }

        return letters.size() == 26;
    }
}
