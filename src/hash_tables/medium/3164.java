package hash_tables.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-the-number-of-good-pairs-ii/
// 3164. Find the Number of Good Pairs IIs
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> hashTable = populateHashTable(nums1);

        return checkHashTable(nums2, k, hashTable);
    }

    private Map<Integer, Integer> populateHashTable(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>();

        for (int number : nums) {
            for (int i = 1; i * i <= number; i++) {
                if (number % i == 0) {
                    hashTable.put(i, hashTable.getOrDefault(i, 0) + 1);
                    if (i * i != number) {
                        hashTable.put(number / i, hashTable.getOrDefault(number / i, 0) + 1);
                    }
                }
            }
        }

        return hashTable;
    }

    private long checkHashTable(int[] nums, int k, Map<Integer, Integer> hashTable) {
        long answer = 0;

        for (int number : nums) {
            number *= k;
            if (hashTable.containsKey(number)) {
                answer += hashTable.get(number);
            }
        }

        return answer;
    }
}