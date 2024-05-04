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

// https://leetcode.com/problems/odd-even-linked-list/description/
// 328. Odd Even Linked List
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        int idx = 1;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddStart = odd;
        ListNode evenStart = even;

        while (head != null) {
            boolean isOdd = idx % 2 == 1;
            if (isOdd) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            idx++;
        }

        odd.next = evenStart.next;
        if (even.next != null)
            even.next = null;
        return oddStart.next;
    }
}
