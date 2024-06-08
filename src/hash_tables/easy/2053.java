package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/kth-distinct-string-in-an-array/description/
// 2053. Kth Distinct String in an Array
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        List<String> distinctList = new ArrayList<>();

        for (String str : arr) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        for (String str : arr) {
            if (countMap.get(str) == 1) {
                distinctList.add(str);
            }
        }

        return k <= distinctList.size() ? distinctList.get(k - 1) : "";
    }
}
