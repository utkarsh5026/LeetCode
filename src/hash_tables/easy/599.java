package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
// 599. Minimum Index Sum of Two Lists
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();
        List<String> commonRestaurants = new LinkedList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int index = 0; index < list1.length; index++) {
            indexMap.put(list1[index], index);
        }

        for (int index2 = 0; index2 < list2.length; index2++) {
            if (indexMap.containsKey(list2[index2])) {
                int index1 = indexMap.get(list2[index2]);
                int indexSum = index1 + index2;

                if (indexSum < minIndexSum) {
                    commonRestaurants.clear();
                    minIndexSum = indexSum;
                }
                if (indexSum == minIndexSum) {
                    commonRestaurants.add(list2[index2]);
                }
            }
        }

        return commonRestaurants.toArray(new String[0]);
    }
}