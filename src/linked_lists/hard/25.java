package linked_lists.hard;

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

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
// 25. Reverse Nodes in k-Group
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = length(head);
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        int groups = length / k;

        for (int i = 0; i < groups; i++) {
            prev.next = reverse(prev.next, k);
            for (int j = 0; j < k; j++) {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    int length(ListNode head) {
        int n = 0;

        while (head != null) {
            head = head.next;
            n++;
        }

        return n;
    }

    ListNode reverse(ListNode head, int length) {
        ListNode curr = head;
        ListNode tail = curr;
        ListNode prev = null;

        for (int i = 0; i < length; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        tail.next = curr;
        return prev;
    }
}