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

// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/
// 2816. Double a Number Represented as a Linked List
class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head == null)
            return null;

        ListNode reversed = reverseNodes(head);
        mulitplyByTwo(reversed);
        return reverseNodes(reversed);
    }

    private ListNode reverseNodes(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void mulitplyByTwo(ListNode head) {
        int carry = 0;
        ListNode curr = head;

        while (curr != null) {
            curr.val = curr.val * 2 + carry;
            carry = curr.val % 10;
            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                break;
            }
        }
    }
}