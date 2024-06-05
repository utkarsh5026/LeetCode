package sliding_window.medium;

import java.util.*;

// https:// leetcode.com/problems/count-number-of-nice-subarrays/description/
// 1248. Count Number of Nice Subarrays
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Map to store indices for each prefix sum
        Map<Integer, List<Integer>> prefixSumIndices = new HashMap<>();
        prefixSumIndices.put(0, new ArrayList<>(Arrays.asList(-1)));

        int currentPrefixSum = 0;
        int countOfNiceSubarrays = 0;

        // Iterate over each number in the array.
        for (int i = 0; i < nums.length; i++) {
            // Increment the prefix sum by 1 if the number is odd.
            currentPrefixSum += nums[i] % 2;

            prefixSumIndices.computeIfAbsent(currentPrefixSum, x -> new ArrayList<>()).add(i);

            if (prefixSumIndices.containsKey(currentPrefixSum - k)) {
                List<Integer> leftIndices = prefixSumIndices.get(currentPrefixSum - k);
                countOfNiceSubarrays += leftIndices.size();
            }
        }

        return countOfNiceSubarrays;
    }
}
