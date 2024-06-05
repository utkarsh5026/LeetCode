package sliding_window.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
// 2958. Length of Longest Subarray With at Most K Frequency
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int maxCnt = Integer.MIN_VALUE;

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            cnt.put(curr, cnt.getOrDefault(curr, 0) + 1);
            while (cnt.containsKey(curr) && cnt.get(curr) > k) {
                int num = nums[left++];
                cnt.put(num, cnt.get(num) - 1);

                if (cnt.get(num) == 0)
                    cnt.remove(num);
            }
            maxCnt = Math.max(maxCnt, i - left + 1);
        }

        return maxCnt;
    }
}
