package linked_lists.easy;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// https://leetcode.com/problems/linked-list-cycle/description/
// 141. Linked List Cycle
class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}