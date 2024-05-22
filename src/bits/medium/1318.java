package bits.medium;

// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
// 1318. Minimum Flips to Make a OR b Equal to c
class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 0) {
                if (bitA == 1)
                    flips++;
                if (bitB == 1)
                    flips++;
            } else {
                if (bitA == 0 && bitB == 0)
                    flips++;
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}
