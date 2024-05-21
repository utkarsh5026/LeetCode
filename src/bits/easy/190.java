package bits.easy;

// https://leetcode.com/problems/reverse-bits/description/
// 190. Reverse Bits
class Solution {

    public int reverseBits(int n) {
        if (n == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            boolean isOneBit = (n & 1) == 1;
            if (isOneBit)
                result = result | 1;
            n >>= 1;
        }

        return result;
    }
}
