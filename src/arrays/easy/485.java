package arrays.easy;

import java.util.*;

// https://leetcode.com/problems/max-consecutive-ones/description/
// 485. Max Consecutive Ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> consecutiveOnes = new ArrayList<>();
        int currStreak = 0;

        for (int num : nums) {
            if (num == 0) {
                consecutiveOnes.add(currStreak);
                currStreak = 0;
                continue;
            }
            currStreak += 1;
        }
        consecutiveOnes.add(currStreak);

        return Collections.max(consecutiveOnes);
    }
}
