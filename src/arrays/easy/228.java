package arrays.easy;

import java.util.*;

// https://leetcode.com/problems/summary-ranges/description/
// 228. Summary Ranges
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];

            if (curr - prev == 1)
                continue;
            updateRange(prev, start, result);
            start = curr;
        }

        updateRange(nums[nums.length - 1], start, result);
        return result;

    }

    private void updateRange(int prev, int start, List<String> ranges) {
        if (start == prev) {
            ranges.add(String.valueOf(prev));
            return;
        }

        String range = start + "->" + prev;
        ranges.add(range);
    }
}