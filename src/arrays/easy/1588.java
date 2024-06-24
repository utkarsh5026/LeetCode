package arrays.easy;

// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/description/
// 1588. Sum of All Odd Length Subarrayss
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr.length == 0)
            return 0;

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int oddLengthSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int last = i > 0 ? prefixSum[i - 1] : 0;
            for (int j = i; j < arr.length; j += 2) {
                oddLengthSum += prefixSum[j] - last;
            }
        }

        return oddLengthSum;
    }
}
