package hash_tables.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/
// 1460. Make Two Arrays Equal by Reversing Subarrays
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> currMap = makeArrMap(arr);
        Map<Integer, Integer> targetNap = makeArrMap(target);

        return compareTwoMaps(currMap, targetNap);
    }

    Map<Integer, Integer> makeArrMap(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        return cnt;
    }

    boolean compareTwoMaps(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        if (a.size() != b.size())
            return false;

        for (Map.Entry<Integer, Integer> cnt : a.entrySet()) {
            int num = cnt.getKey();
            int count = cnt.getValue();

            if (b.getOrDefault(num, 0) != count)
                return false;
        }
        return true;
    }
}