package arrays.easy;

// https://leetcode.com/problems/count-good-triplets/description/
// 1534. Count Good Triplets
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;

        // Iterate over all possible triplets (i, j, k) where 0 <= i < j < k <
        // arr.length
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Check conditions
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}