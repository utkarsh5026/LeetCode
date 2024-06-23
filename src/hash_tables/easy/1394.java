package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/find-lucky-integer-in-an-array/description/
// 1394. Find Lucky Integer in an Arrays
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int largest = -1;
        for (Map.Entry<Integer, Integer> cnt : freq.entrySet()) {
            int num = cnt.getKey();
            if (num == cnt.getValue() && num > largest)
                largest = num;
        }

        return largest;
    }
}