package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/
// 1865. Finding Pairs With a Certain Sum
class FindSumPairs {

    int[] nums;
    Map<Integer, Integer> nums1Cnt;
    Map<Integer, Integer> nums2Cnt;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums = nums2;
        this.nums1Cnt = new HashMap<>();
        this.nums2Cnt = new HashMap<>();
        for (int num : nums1) {
            nums1Cnt.put(num, nums1Cnt.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            nums2Cnt.put(num, nums2Cnt.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int curr = nums[index];
        nums2Cnt.put(curr, nums2Cnt.get(curr) - 1);

        if (nums2Cnt.get(curr) == 0)
            nums2Cnt.remove(curr);

        nums[index] += val;
        curr = nums[index];
        nums2Cnt.put(curr, nums2Cnt.getOrDefault(curr, 0) + 1);
    }

    public int count(int tot) {
        int total = 0;
        for (Map.Entry<Integer, Integer> cnt : nums1Cnt.entrySet()) {
            int diff = tot - cnt.getKey();
            total += nums2Cnt.getOrDefault(diff, 0) * cnt.getValue();
        }
        return total;
    }
}
