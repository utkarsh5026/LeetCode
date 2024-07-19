package sliding_window.medium;

import java.util.*;

// https://leetcode.com/problems/count-complete-subarrays-in-an-array/
// 2799. Count Complete Subarrays in an Array
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> currNums = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                currNums.add(nums[j]);
                if (currNums.size() != unique.size())
                    continue;
                cnt += nums.length - j;
                break;
            }
        }

        return cnt;
    }
}
