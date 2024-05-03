package stacks.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/removing-stars-from-a-string/description/
// 2390. Removing Stars From a String
class Solution {
    public String removeStars(String s) {
        Deque<Character> chars = new ArrayDeque<>();

        int start = 0;
        while (start < s.length()) {
            char curr = s.charAt(start);
            start++;
            if (curr == '*')
                chars.pollLast();
            else
                chars.add(curr);
        }
        return createResultString(chars);
    }

    public String createResultString(Deque<Character> chars) {
        StringBuilder result = new StringBuilder();

        while (!chars.isEmpty()) {
            result.append(chars.pollFirst());
        }
        return result.toString();
    }

}