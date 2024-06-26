package two_pointers.easy;

// https://leetcode.com/problems/reverse-string/description/
// 344. Reverse String
class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char a = s[start];
            char b = s[end];

            s[end--] = a;
            s[start++] = b;
        }
    }
}
