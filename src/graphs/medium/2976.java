package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/
// 2976. Minimum Cost to Convert String I
class Solution {
    private static final int ALPHABET_SIZE = 26;
    private static final long INF = Long.MAX_VALUE / 2;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] minCost = new long[ALPHABET_SIZE][ALPHABET_SIZE];
        for (long[] row : minCost) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            minCost[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            minCost[u][v] = Math.min(minCost[u][v], cost[i]);
        }

        for (int k = 0; k < ALPHABET_SIZE; k++) {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                for (int j = 0; j < ALPHABET_SIZE; j++) {
                    minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                }
            }
        }

        // Step 2: Calculate the minimum cost
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (u != v) {
                if (minCost[u][v] == INF) {
                    return -1;
                }
                totalCost += minCost[u][v];
            }
        }

        return totalCost;
    }
}