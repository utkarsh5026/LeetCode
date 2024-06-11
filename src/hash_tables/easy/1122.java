package hash_tables.easy;

import java.util.*;

//https://leetcode.com/problems/relative-sort-array/description/
// 1122. Relative Sort Array
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2Numbers = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            arr2Numbers.put(arr2[i], i);
        }

        List<Integer> arr1List = new ArrayList<>();
        for (int num : arr1) {
            arr1List.add(num);
        }

        Collections.sort(arr1List, (a, b) -> {
            int arr2AIdx = arr2Numbers.getOrDefault(a, -1);
            int arr2BIdx = arr2Numbers.getOrDefault(b, -1);

            if (arr2AIdx == -1 || arr2BIdx == -1)
                return a - b;

            if (arr2AIdx >= 0 && arr2BIdx >= 0)
                return arr2AIdx - arr2BIdx;
            return 0;
        });

        for (int i = 0; i < arr1List.size(); i++) {
            arr1[i] = arr1List.get(i);
        }

        return arr1;
    }
}