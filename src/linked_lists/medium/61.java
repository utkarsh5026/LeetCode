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

// https://leetcode.com/problems/rotate-list/description/
// 61. Rotate List
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        int length = getLength(head);
        k = k % length;
        int newHeadDistFromStart = (length - k) % length;
        ListNode newHead = getNodeAtRotatingPoint(head, newHeadDistFromStart);

        attachNewHeadToPrevHead(newHead, head);
        return newHead;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }

    private ListNode getNodeAtRotatingPoint(ListNode head, int dist) {
        ListNode curr = head;
        for (int i = 0; i < dist; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private void attachNewHeadToPrevHead(ListNode newHead, ListNode prevNode) {
        ListNode curr = newHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = prevNode;
        while (prevNode.next != newHead) {
            prevNode = prevNode.next;
        }
        prevNode.next = null;
    }
}