package hash_tables.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-the-number-of-good-pairs-i/description/
// 3162. Find the Number of Good Pairs I
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> productMap = new HashMap<>();

        for (int num : nums2) {
            int product = num * k;
            productMap.put(product, productMap.getOrDefault(product, 0) + 1);
        }

        int count = 0;
        for (int num : nums1) {
            for (Map.Entry<Integer, Integer> entry : productMap.entrySet()) {
                int product = entry.getKey();
                int freq = entry.getValue();
                if (num % product == 0) {
                    count += freq;
                }
            }
        }

        return count;
    }
}
