package hash_tables.easy;

import java.util.*;

// https:// leetcode.com/problems/merge-similar-items/description/
// 2363. Merge Similar Items
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> valueWeightMap = new TreeMap<>();

        // Process items1
        for (int[] item : items1) {
            int value = item[0];
            int weight = item[1];
            valueWeightMap.put(value, valueWeightMap.getOrDefault(value, 0) + weight);
        }

        // Process items2
        for (int[] item : items2) {
            int value = item[0];
            int weight = item[1];
            valueWeightMap.put(value, valueWeightMap.getOrDefault(value, 0) + weight);
        }

        // Convert the TreeMap to the required 2D list format
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : valueWeightMap.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            result.add(pair);
        }

        return result;
    }
}