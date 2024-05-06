package strings.easy;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// 28. Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) {
        int hayIdx = 0;

        while (hayIdx < haystack.length()) {
            int hayStartAt = hayIdx;
            int neeIdx = 0;

            while (neeIdx < needle.length() && hayStartAt < haystack.length()) {
                char nedChar = needle.charAt(neeIdx);
                char hayChar = haystack.charAt(hayStartAt);
                if (nedChar != hayChar)
                    break;
                neeIdx++;
                hayStartAt++;
            }

            if (neeIdx == needle.length())
                return hayIdx;
            hayIdx++;
        }

        return -1;
    }
}