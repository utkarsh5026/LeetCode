package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/
// 2610. Convert an Array Into a 2D Array With Conditions
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> matrix = new ArrayList<>();
        while (!cnt.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> iterator = cnt.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                row.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);

                if (entry.getValue() == 0) {
                    iterator.remove();
                }
            }
            matrix.add(row);
        }

        return matrix;
    }
}
