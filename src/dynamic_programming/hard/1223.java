package dynamic_programming.hard;


import java.util.Arrays;

// https://leetcode.com/problems/dice-roll-simulation/description/
// 1223. Dice Roll Simulation
class Solution {

    private static final int MOD = 1000000007;
    private int[][][] memo;
    private int[] rollMax;

    public int dieSimulator(int n, int[] rollMax) {
        this.rollMax = rollMax;
        this.memo = new int[n + 1][7][16]; // n+1 for positions, 7 for faces (0-6), 16 for counts (max rollMax value + 1)
        for (int[][] layer : memo) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return helper(n, 0, 0, 0);
    }

    private int helper(int n, int pos, int last, int count) {
        if (pos == n) {
            return 1;
        }
        if (memo[pos][last][count] != -1) {
            return memo[pos][last][count];
        }

        int result = 0;
        for (int face = 1; face <= 6; face++) {
            if (face == last) {
                if (count + 1 <= rollMax[face - 1]) {
                    result = (result + helper(n, pos + 1, face, count + 1)) % MOD;
                }
            } else {
                result = (result + helper(n, pos + 1, face, 1)) % MOD;
            }
        }
        memo[pos][last][count] = result;
        return result;
    }

}
