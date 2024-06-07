package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/
// 2744. Find Maximum Number of String Pairs
class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> seen = new HashSet<>();
        int pairCount = 0;

        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (seen.contains(reversedWord)) {
                pairCount++;
                seen.remove(reversedWord); // remove to ensure one-to-one pairing
            } else {
                seen.add(word);
            }
        }

        return pairCount;
    }
}
