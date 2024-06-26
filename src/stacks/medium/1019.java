package stacks.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// https://leetcode.com/problems/next-greater-node-in-linked-list/description/
// 1019. Next Greater Node In Linked List
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] nextLarger = new int[nodes.size()];
        Arrays.fill(nextLarger, 0);

        for (int i = 0; i < nextLarger.length; i++) {
            int curr = nodes.get(i);
            while (!stack.isEmpty() && nodes.get(stack.peekLast()) < curr) {
                int idx = stack.pollLast();
                nextLarger[idx] = curr;
            }
            stack.add(i);
        }

        return nextLarger;
    }

}
