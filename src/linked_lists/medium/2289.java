package linked_lists.medium;

import java.util.*;

// https://leetcode.com/problems/steps-to-make-array-non-decreasing/description/
// 2289. Steps to Make Array Non-decreasing
class Solution {
    private class Node {
        int val;
        int count;

        Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int totalSteps(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int maxSteps = 0;
        Deque<Node> stack = new ArrayDeque<>();

        for (int num : nums) {
            int maxCount = 0;
            while (!stack.isEmpty() && stack.peek().val <= num) {
                Node node = stack.pop();
                maxCount = Math.max(maxCount, node.count);
            }

            if (stack.isEmpty()) {
                stack.push(new Node(num, 0));
            } else {
                stack.push(new Node(num, maxCount + 1));
                maxSteps = Math.max(maxSteps, maxCount + 1);
            }
        }

        return maxSteps;
    }
}