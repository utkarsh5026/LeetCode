package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/rank-transform-of-an-array/description/
// 1331. Rank Transform of an Array
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        for (int num : arr) {
            unique.add(num);
        }

        Integer[] uniqueArray = unique.toArray(new Integer[0]);
        Arrays.sort(uniqueArray);

        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < uniqueArray.length; i++) {
            rank.put(uniqueArray[i], i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        return arr;
    }
}