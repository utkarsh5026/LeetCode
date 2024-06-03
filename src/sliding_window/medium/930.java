package sliding_window.medium;

import java.util.*;

// https://leetcode.com/problems/binary-subarrays-with-sum/description/
// 930. Binary Subarrays With Sum
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> sumCnt = new HashMap<>();
        sumCnt.put(0, 1);
        int cnt = 0;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            int diff = currSum - goal;
            cnt += sumCnt.getOrDefault(diff, 0);
            sumCnt.put(currSum, sumCnt.getOrDefault(currSum, 0) + 1);
        }
        return cnt;
    }
}
