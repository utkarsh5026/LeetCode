package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/contains-duplicate-ii/description/
// 219. Contains Duplicate II
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIdxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!numIdxMap.containsKey(num)) {
                numIdxMap.put(num, i);
                continue;
            }

            int prevIdx = numIdxMap.get(num);
            if (i - prevIdx <= k)
                return true;
            numIdxMap.put(num, i);
        }

        return false;
    }
}
