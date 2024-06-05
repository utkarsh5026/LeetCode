package trees.medium;

// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
// 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int windowSum = 0;
        int requiredSum = k * threshold;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Check the first window
        if (windowSum >= requiredSum) {
            count++;
        }

        // Sliding window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];

            // Check the updated window sum
            if (windowSum >= requiredSum) {
                count++;
            }
        }

        return count;
    }
}
