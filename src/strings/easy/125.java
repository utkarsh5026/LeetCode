package strings.easy;

// https://leetcode.com/problems/valid-palindrome/description/
// 125. Valid Palindrome
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = s.length() - 1;

        if (s.length() == 0)
            return true;

        while (start <= end) {
            char fromStart = s.charAt(start);
            char fromEnd = s.charAt(end);

            if (fromStart != fromEnd)
                return false;

            start++;
            end--;
        }
        return true;
    }
}