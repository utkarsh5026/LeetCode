package arrays.easy;

import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/
// 2824. Count Pairs Whose Sum is Less than Target
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += right - left; // update the count
                left++; // increment the left
            } else
                right--;

        }
        return count;
    }
}