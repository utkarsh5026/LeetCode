package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/unique-number-of-occurrences/description/
// 1207. Unique Number of Occurrences
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberCntMap = new HashMap<>();
        for (int num : arr) {
            numberCntMap.compute(num, (k, v) -> (v == null) ? 1 : v + 1);
        }
        return allOccurencesDifferent(numberCntMap.values());
    }

    public boolean allOccurencesDifferent(Collection<Integer> occurences) {
        Set<Integer> allOccurences = new HashSet<>();
        for (int occurence : occurences) {
            allOccurences.add(occurence);
        }
        return allOccurences.size() == occurences.size();
    }

}