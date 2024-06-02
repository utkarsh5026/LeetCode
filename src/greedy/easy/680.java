package greedy.easy;

// https://leetcode.com/problems/valid-palindrome-ii/description/
// 680. Valid Palindrome II
class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() <= 2)
            return true;

        int left = 0;
        int right = s.length() - 1;
        int deleted = 0;

        while (left < right) {
            char begin = s.charAt(left);
            char end = s.charAt(right);

            if (begin == end) {
                left++;
                right++;
                continue;
            }

            deleted++;
            if (s.charAt(left + 1) == s.charAt(right)) {
                left++;
            } else if (s.charAt(right - 1) == s.charAt(left)) {
                right--;
            }

            if (deleted > 1)
                return false;
        }

        return deleted <= 1;
    }
}