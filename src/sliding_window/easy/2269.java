package sliding_window.easy;

// https://leetcode.com/problems/find-the-k-beauty-of-a-number/description/
// 2269. Find the K-Beauty of a Number
class Solution {
    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int cnt = 0;

        StringBuilder divisor = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            char digit = numStr.charAt(i);
            divisor.append(digit);

            if (divisor.length() < k)
                continue;

            int begin = i - k + 1;
            int kSizeDigit = Integer.parseInt(divisor.substring(begin));

            if (kSizeDigit != 0 && num % kSizeDigit == 0)
                cnt++;
        }

        return cnt;
    }
}