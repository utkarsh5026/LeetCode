package stacks.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/simplify-path/description/
// 71. Simplify Path
class Solution {
    public String simplifyPath(String path) {
        String doubleSlashReplaced = path.replaceAll("//+", "/");
        Deque<String> paths = new ArrayDeque<>();

        String[] directories = doubleSlashReplaced.split("/");

        // start = 0 we have an empty string
        int start = 1;

        while (start < directories.length) {
            String directory = directories[start];
            start++;

            boolean sameDirectory = directory.equals(".");
            if (sameDirectory)
                continue;

            boolean parentDirectory = directory.equals("..");
            if (parentDirectory) {
                if (!paths.isEmpty())
                    paths.pollLast();
                continue;
            }
            paths.add(directory);
        }
        return "/" + String.join("/", paths);
    }

}