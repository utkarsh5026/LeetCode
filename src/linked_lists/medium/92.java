package linked_lists.medium;

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

// https://leetcode.com/problems/reverse-linked-list-ii/description/
// 92. Reverse Linked List II
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        prev.next = reverse(prev.next, right - left + 1);
        return dummy.next;
    }

    ListNode reverse(ListNode head, int length) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode tail = curr;

        for (int i = 0; i < length; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        tail.next = curr; // Connect the tail of reversed portion to the rest of the list
        return prev; // Return the new head of the reversed portion
    }
}