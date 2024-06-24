package stacks.easy;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/crawler-log-folder/description/
// 1598. Crawler Log Folder
class Solution {
    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();

        for (String folder : logs) {
            if (folder.contains("..") && !stack.isEmpty())
                stack.pollLast();

            else if (!folder.contains("."))
                stack.add(folder);
        }
        return stack.size();
    }
}