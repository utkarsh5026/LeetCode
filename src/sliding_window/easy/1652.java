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

        int[] prefixSum = getPrefixSum(code);

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Calculate indices for summing k elements to the right
                int start = (i + 1) % n;
                int end = (i + k) % n;
                if (end >= start) {
                    sum = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
                } else {
                    // Wrap around case
                    sum = prefixSum[n - 1] - (start > 0 ? prefixSum[start - 1] : 0) + prefixSum[end];
                }
            } else {
                // Calculate indices for summing |k| elements to the left
                int start = (i + k + n) % n;
                int end = (i - 1 + n) % n;
                if (start <= end) {
                    sum = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
                } else {
                    sum = prefixSum[end] + (start > 0 ? prefixSum[n - 1] - prefixSum[start - 1] : prefixSum[n - 1]);
                }
            }

            decrypted[i] = sum;
        }
        return decrypted;
    }

    private int[] getPrefixSum(int[] code) {
        int n = code.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = code[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + code[i];
        }
        return prefixSum;
    }
}
