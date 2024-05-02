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

// https://leetcode.com/problems/add-two-numbers/description
// 2. Add Two Numbers
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int total = l1Val + l2Val + carry;
            ListNode node = new ListNode(total % 10);
            carry = total / 10;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            curr.next = node;
            curr = curr.next;
        }

        return head.next;
    }
}