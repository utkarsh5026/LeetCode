package linked_lists.medium;

import java.util.ArrayDeque;
import java.util.Deque;

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

// https://leetcode.com/problems/add-two-numbers-ii/description/
// 445. Add Two Numbers II
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();

        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }

        return add(s1, s2);
    }

    ListNode add(Deque<Integer> s1, Deque<Integer> s2) {
        Deque<Integer> result = new ArrayDeque<>();
        int carry = 0;

        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int a = !s1.isEmpty() ? s1.pollLast() : 0;
            int b = !s2.isEmpty() ? s2.pollLast() : 0;

            int sum = a + b + carry;

            result.add(sum % 10);
            carry = sum / 10;
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (!result.isEmpty()) {
            int num = result.pollLast();
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }
}