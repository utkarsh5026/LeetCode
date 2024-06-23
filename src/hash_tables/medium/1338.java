package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/reduce-array-size-to-the-half/description/
// 1338. Reduce Array Size to The Half
class Solution {
    public int minSetSize(int[] arr) {
        int arrLen = arr.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        List<Integer> nums = new ArrayList<>(cnt.keySet());
        Collections.sort(nums, (a, b) -> {
            return cnt.get(b) - cnt.get(a);
        });

        int setSize = 0;

        for (int num : nums) {
            if (arrLen <= arr.length / 2)
                break;

            arrLen -= cnt.get(num);
            setSize++;
        }
        return setSize;
    }
}