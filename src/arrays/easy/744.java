package arrays.easy;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
// 744. Find Smallest Letter Greater Than Target
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        if (target == 'z')
            return letters[0];

        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            char ch = letters[mid];

            if (target >= ch)
                left = mid + 1;
            else
                right = mid;
        }

        if (letters[left] <= target)
            return letters[0];
        return letters[left];
    }
}