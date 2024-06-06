package greedy.medium;

import java.util.*;

// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/
// 1296. Divide Array in Sets of K Consecutive Numbers
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0)
            return false;

        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int h = nums[i];
            numCnt.put(h, numCnt.getOrDefault(h, 0) + 1);
        }

        while (!numCnt.keySet().isEmpty()) {
            int min = Collections.min(numCnt.keySet());
            int cnt = 0;
            while (cnt < k) {
                if (!numCnt.containsKey(min))
                    return false;

                numCnt.put(min, numCnt.get(min) - 1);
                if (numCnt.get(min) == 0)
                    numCnt.remove(min);
                cnt++;
                min++;
            }
        }
        return true;
    }
}