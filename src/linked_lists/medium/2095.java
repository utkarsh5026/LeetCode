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

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
// 2095. Delete the Middle Node of a Linked List

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        int length = getLength(head);
        int midPos = length / 2;
        ListNode curr = head;

        deleteMiddleNode(curr, midPos);
        return head;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    private void deleteMiddleNode(ListNode head, int midPos) {
        for (int i = 0; i < midPos - 1; i++) {
            head = head.next;
        }
        if (head != null && head.next != null)
            head.next = head.next.next;
    }
}
