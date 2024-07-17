package stacks.medium;

import java.util.*;

// https://leetcode.com/problems/build-an-array-with-stack-operations/description/
// 1441. Build an Array With Stack Operations
class Solution {

    private static final String PUSH = "Push";
    private static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {

        int idx = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> operations = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (idx == target.length)
                break;

            if (i < target[idx]) {
                stack.add(i);
                operations.add(PUSH);
            } else if (i == target[idx]) {
                while (!stack.isEmpty() && stack.peekLast() < i) {
                    stack.pollLast();
                    operations.add(POP);
                }
                idx++;
                operations.add(PUSH);
            }
        }

        return operations;
    }
}