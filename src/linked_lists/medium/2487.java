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

// https://leetcode.com/problems/remove-nodes-from-linked-list/description/
// 2487. Remove Nodes From Linked List
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null)
            return null;
        ListNode reversed = reverseNodes(head);
        ListNode newHead = removeSmallerNodes(reversed);
        return reverseNodes(newHead);
    }

    private ListNode reverseNodes(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    private ListNode removeSmallerNodes(ListNode head) {
        ListNode curr = head;
        ListNode prev = new ListNode(0);
        ListNode prevFollow = prev;
        int maxValue = Integer.MIN_VALUE;

        while (curr != null) {
            while (curr != null && curr.val < maxValue) {
                curr = curr.next;
            }

            prevFollow.next = curr;
            prevFollow = prevFollow.next;
            if (curr != null) {
                maxValue = curr.val;
                curr = curr.next;
            }
        }

        return prev.next;
    }
}