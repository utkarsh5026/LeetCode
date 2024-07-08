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

// https://leetcode.com/problems/insertion-sort-list/description/
// 147. Insertion Sort List
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = new ListNode();

        while (head != null) {
            ListNode toInsert = new ListNode(head.val);
            head = head.next;
            sorted.next = insert(sorted.next, toInsert);
        }

        return sorted.next;
    }

    ListNode insert(ListNode head, ListNode toInsert) {
        ListNode sorted = head;

        if (sorted == null)
            return toInsert;

        if (sorted != null && toInsert.val <= sorted.val) {
            toInsert.next = sorted;
            return toInsert;
        }
        while (sorted != null) {
            boolean largerThanCurr = toInsert.val >= sorted.val;
            boolean smallerThanNext = sorted.next == null || (sorted.next != null && sorted.next.val >= toInsert.val);

            if (largerThanCurr && smallerThanNext) {
                ListNode next = sorted.next;
                sorted.next = toInsert;
                toInsert.next = next;
                break;
            }

            sorted = sorted.next;
        }

        return head;
    }
}