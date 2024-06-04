package sliding_window.easy;

import java.util.Arrays;

// https://leetcode.com/problems/defuse-the-bomb/description/
//1652. Defuse the Bomb
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        if (k == 0) {
            Arrays.fill(decrypted, 0);
            return decrypted;
        }

        int[] prefixSum = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            prefixSum[i] = prefixSum[i - 1] + code[(i - 1) % n];
        }

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                // Sum from i+1 to i+k, handle circular array indexing
                decrypted[i] = prefixSum[i + k + 1] - prefixSum[i + 1];
            } else {
                // Sum from i+k to i-1, handle circular array indexing
                int start = i + k + n; // Adjust for negative k
                int end = i + n; // We need to include index i-1
                decrypted[i] = prefixSum[end] - prefixSum[start];
            }
        }

        return decrypted;
    }
}