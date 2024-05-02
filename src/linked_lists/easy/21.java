package linked_lists.easy;

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

// https://leetcode.com/problems/merge-two-sorted-lists/description/
// 21. Merge Two Sorted Lists
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (list1 != null || list2 != null) {
            int list1Val = list1 == null ? Integer.MAX_VALUE : list1.val;
            int list2Val = list2 == null ? Integer.MAX_VALUE : list2.val;

            ListNode node = new ListNode(Math.min(list1Val, list2Val));
            curr.next = node;
            curr = curr.next;

            if (list1 != null && list1Val < list2Val)
                list1 = list1.next;
            else if (list2 != null)
                list2 = list2.next;
        }

        return head.next;
    }
}