package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/clear-digits/description/
// 3174. Clear Digits
class Solution {
    public String clearDigits(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> indicesToDelete = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch))
                stack.add(i);

            else {
                if (!stack.isEmpty()) {
                    indicesToDelete.add(stack.pollLast());
                    indicesToDelete.add(i);
                }
            }
        }

        StringBuilder cleared = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indicesToDelete.contains(i))
                cleared.append(s.charAt(i));
        }

        return cleared.toString();
    }
}
