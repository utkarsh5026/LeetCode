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

// https://leetcode.com/problems/merge-in-between-linked-lists/description/
// 1669. Merge In Between Linked Lists
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        if (list1 == null)
            return null;

        ListNode curr = list1;
        for (int i = 0; i < a - 1; i++) {
            curr = curr.next;
        }

        ListNode deleteStart = curr.next;
        curr.next = list2;

        int range = b - a;
        for (int i = 0; i < range; i++) {
            deleteStart = deleteStart.next;
        }
        ListNode lastList2Node = getL2LastNode(list2);
        lastList2Node.next = deleteStart.next;
        return list1;
    }

    ListNode getL2LastNode(ListNode l) {
        ListNode curr = l;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

}
